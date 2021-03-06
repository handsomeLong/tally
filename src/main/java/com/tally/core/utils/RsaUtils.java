package com.tally.core.utils;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class RsaUtils {
	// 签名对象
	private static Signature sign;
	private static final RsaUtils rsaHelper = new RsaUtils();

	private String pubkey;
	private String prikey_pkcs8;
	private String prikey_openssl;

	private RsaUtils() {
		try {
			sign = Signature.getInstance("SHA1withRSA");
		} catch (NoSuchAlgorithmException nsa) {
			System.out.println("" + nsa.getMessage());
		}
	}

	public static RsaUtils getInstance() {
		return rsaHelper;
	}

	private PrivateKey getPrivateKey(String privateKeyStr) {
		try {
			byte[] privateKeyBytes = b64decode(privateKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
					privateKeyBytes);
			return keyFactory.generatePrivate(privateKeySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static PublicKey getPublicKey(String publicKeyStr) {
		try {
			byte[] publicKeyBytes = b64decode(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
					publicKeyBytes);
			return keyFactory.generatePublic(publicKeySpec);

		} catch (InvalidKeySpecException e) {
			
			return null;
		} catch (NoSuchAlgorithmException e) {
		
			return null;
		}
	}

	/**
	 * RSA 数据签名
	 * 
	 * @param toBeSigned
	 *            (待签名的原文)
	 * @param priKey
	 *            (RSA私钥）
	 * @return （返回RSA签名后的数据签名数据base64编码）
	 */
	public String signData(String toBeSigned, String priKey) {

		try {
			PrivateKey privateKey = getPrivateKey(priKey);
			byte[] signByte = toBeSigned.getBytes("utf-8");
			Signature rsa = Signature.getInstance("SHA1withRSA");
			rsa.initSign(privateKey);
			rsa.update(signByte);
			return b64encode(rsa.sign());
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		} catch (InvalidKeyException in) {
			in.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		}
		return null;
	}

	/**
	 * RSA 数据签名验证
	 * 
	 * @param signature
	 *            （RSA签名数据（base64编码）
	 * @param data
	 *            （待验证的数据原文）
	 * @param pubKey
	 *            （RSA公钥数据）
	 * @return 返回验证结果（TRUE:验证成功；FALSE:验证失败）
	 */
	public static boolean verifySignature(String signature, String data, String pubKey) {
		try {
			byte[] signByte = b64decode(signature);
			byte[] dataByte = data.getBytes("utf-8");
			PublicKey publicKey = getPublicKey(pubKey);
			sign.initVerify(publicKey);
			sign.update(dataByte);
			return sign.verify(signByte);
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * base64编码
	 * 
	 * @param data
	 * @return
	 */
	private String b64encode(byte[] data) {
		return new BASE64Encoder().encode(data);
	}

	/**
	 * base64解码
	 * 
	 * @param data
	 * @return
	 */
	private static byte[] b64decode(String data) {
		try {
			return new BASE64Decoder().decodeBuffer(data);
		} catch (Exception ex) {
		}
		return null;
	}

	/**
	 * RSA数据加密
	 * 
	 * @param data
	 *            （需要加密的数据）
	 * @param pubKey
	 *            （RSA公钥）
	 * @return 返回加密后的密文（BASE64编码）
	 */
	public String encryptData(String data, String pubKey) {
		try {
			byte[] dataByte = data.getBytes("utf-8");
			PublicKey publicKey = getPublicKey(pubKey);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			byte[] dataReturn = new byte[] {};
			// StringBuilder sb = new StringBuilder();
			for (int i = 0; i < dataByte.length; i += 100) {
				byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(dataByte,
						i, i + 100));
				// sb.append(new String(doFinal));
				dataReturn = ArrayUtils.addAll(dataReturn, doFinal);
			}

			// return b64encode(cipher.doFinal(dataByte));
			return b64encode(dataReturn);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * RSA数据解密
	 * 
	 * @param encryptedData
	 *            （需要解密的数据base64编码数据）
	 * @param priKey
	 *            （RSA的私钥）
	 * @return 返回解密后的原始明文
	 */
	public String decryptData(String encryptedData, String priKey) {
		try {
			byte[] encryData = b64decode(encryptedData);
			PrivateKey privateKey = getPrivateKey(priKey);
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < encryData.length; i += 128) {
				byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(encryData,
						i, i + 128));
				sb.append(new String(doFinal, "utf-8"));
			}

			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	public static JSONObject parseWxMiniPhone(String session_key, String encryptedData, String iv) {

		byte[] dataByte = Base64.decode(encryptedData);

		byte[] keyByte = Base64.decode(session_key);

		byte[] ivByte = Base64.decode(iv);
		try {

			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				JSONObject parse = (JSONObject) JSONObject.parse(result);
				return parse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到私钥字符串（经过base64编码）
	 * 
	 * @return
	 */
	public static String getPriKeyString(PrivateKey key, String EncodeType)
			throws Exception {
		// byte[] keyBytes = key.getEncoded();
		// System.out.println("length:"+keyBytes.length);
		byte[] keyBytes = EncodeKey(key, EncodeType);
		String s = (new BASE64Encoder()).encode(keyBytes);
		return s;
	}

	/**
	 * 得到公钥字符串（经过base64编码）
	 * 
	 * @return
	 */
	public static String getPubKeyString(PublicKey key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		// System.out.println("length:"+keyBytes.length);
		String s = (new BASE64Encoder()).encode(keyBytes);
		return s;
	}

	public static byte[] EncodeKey(PrivateKey pKey, String EncodeType)
			throws Exception {
		if (EncodeType.equals("pkcs8")) {
			return pKey.getEncoded();
		} else if (EncodeType.equals("openssl")) {
			RSAPrivateCrtKey rsaKey = (RSAPrivateCrtKey) pKey;
			RSAPrivateKeyStructure rsastruct = new RSAPrivateKeyStructure(
					rsaKey.getModulus(), rsaKey.getPublicExponent(),
					rsaKey.getPrivateExponent(), rsaKey.getPrimeP(),
					rsaKey.getPrimeQ(), rsaKey.getPrimeExponentP(),
					rsaKey.getPrimeExponentQ(), rsaKey.getCrtCoefficient());
			ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
			DEROutputStream deroutputstream = new DEROutputStream(
					bytearrayoutputstream);
			deroutputstream.writeObject(rsastruct.getDERObject());
			deroutputstream.close();
			return bytearrayoutputstream.toByteArray();
		}
		return null;
	}

	/**
	 * 生成密钥 自动产生RSA1024位密钥；并保持到文件里 rsaPublicKeyFilePath
	 * 公钥的文件路径名，例如：d:\publickey.txt rsaPrivateKeyFilePath
	 * 公钥的文件路径名，例如：d:\privatekey.txt
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public void getAutoCreateRSA() throws NoSuchAlgorithmException, IOException {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024);
			KeyPair kp = kpg.genKeyPair();
			PublicKey puk = kp.getPublic();
			PrivateKey prk = kp.getPrivate();

			// System.out.println(prk.getFormat());

			pubkey = getPubKeyString(puk);
			prikey_pkcs8 = getPriKeyString(prk, "pkcs8");
			prikey_openssl = getPriKeyString(prk, "openssl");

			// System.out.println("pubkey:" + pubkey);
			// System.out.println("prikey_pkcs8:" + prikey_pkcs8);
			// System.out.println("prikey_openssl:" + prikey_openssl);

			// System.out.println(prikey.length());

			// X509EncodedKeySpec ksp = new
			// X509EncodedKeySpec(puk.getEncoded());
			// FileOutputStream fos = new
			// FileOutputStream("F:\\test-public.key");
			// fos.write(ksp.getEncoded());
			// fos.close();
			//
			// PKCS8EncodedKeySpec kpr = new
			// PKCS8EncodedKeySpec(prk.getEncoded());
			// fos = new FileOutputStream("F:\\test-private.key");
			// fos.write(kpr.getEncoded());
			// fos.close();

			// String rsaPublicKeyFilePath="F:\\java-pub.pem";
			// FileOutputStream pufos = new
			// FileOutputStream(rsaPublicKeyFilePath);
			// ObjectOutputStream puoos = new ObjectOutputStream(pufos);
			// puoos.writeObject(puk);
			// puoos.flush();
			// puoos.close();
			// String rsaPrivateKeyFilePath="F:\\java-pri.pem";
			// FileOutputStream prfos = new
			// FileOutputStream(rsaPrivateKeyFilePath);
			// ObjectOutputStream proos = new ObjectOutputStream(prfos);
			// proos.writeObject(prk);
			// proos.flush();
			// proos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPubkey() {
		return pubkey;
	}

	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	public String getPrikey_pkcs8() {
		return prikey_pkcs8;
	}

	public void setPrikey_pkcs8(String prikeyPkcs8) {
		prikey_pkcs8 = prikeyPkcs8;
	}

	public String getPrikey_openssl() {
		return prikey_openssl;
	}

	public void setPrikey_openssl(String prikeyOpenssl) {
		prikey_openssl = prikeyOpenssl;
	}

}

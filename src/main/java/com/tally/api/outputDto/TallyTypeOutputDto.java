package com.tally.api.outputDto;

import lombok.Data;

/**
 * 收支类型
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class TallyTypeOutputDto {

    private Integer inOutTypeId;

    private String inOutTypeName;

    private Integer typeId;

    private Integer type;

    private String typeCode;

    private Integer subClassType;

    private String typeName;

    private String collectTypeName;

    public TallyTypeOutputDto(Integer inOutTypeId, String inOutTypeName, Integer typeId, Integer type, String typeCode, Integer subClassType, String typeName, String collectTypeName) {
        this.inOutTypeId = inOutTypeId;
        this.inOutTypeName = inOutTypeName;
        this.typeId = typeId;
        this.type = type;
        this.typeCode = typeCode;
        this.subClassType = subClassType;
        this.typeName = typeName;
        this.collectTypeName = collectTypeName;
    }

    public TallyTypeOutputDto() {
    }
}
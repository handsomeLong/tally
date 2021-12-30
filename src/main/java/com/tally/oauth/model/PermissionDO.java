package com.tally.oauth.model;

import lombok.Data;

/**
 * @author joetao
 */

@Data
public class PermissionDO {
    private Long id;
    private String name;
    private String path;
    private String method;
}

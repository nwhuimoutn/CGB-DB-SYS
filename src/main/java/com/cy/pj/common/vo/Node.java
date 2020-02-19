package com.cy.pj.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node implements Serializable {
    private static final long serialVersionUID = 3844884478349477632L;

    private Integer id;
    private String name;
    private Integer parentId;

}

package com.binar.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDataDB {


        private String filename;
        private String fileType;
        private byte[] data;

}


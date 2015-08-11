package com.chao.mars_http_geocode;

/**
 * Created by chao on 2015/5/14.
 */
public class Inresult {

        private String[] types;
        private String formatted_address;

        public String[] getTypes() {
            return types;
        }

        public void setTypes(String[] types) {
            this.types = types;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }
    }



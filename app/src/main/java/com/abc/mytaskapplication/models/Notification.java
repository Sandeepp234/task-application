package com.abc.mytaskapplication.models;

public class Notification  {

        private String date;
        private String url;
        private String notice;

        // Getter Methods

        public String getDate() {
            return date;
        }

        public String getUrl() {
            return url;
        }

        public String getNotice() {
            return notice;
        }

        // Setter Methods

        public void setDate(String date) {
            this.date = date;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
}

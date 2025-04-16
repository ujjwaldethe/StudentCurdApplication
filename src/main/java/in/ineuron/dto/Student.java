package in.ineuron.dto;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {

        @Serial
        private static final long serialVersionUID=1L;
        private Integer sid;
        private String name;
        private Integer sage;
        private String saddress;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getSid() {
                return sid;
        }

        public void setSid(Integer sid) {
                this.sid = sid;
        }

        public String getSaddress() {
                return saddress;
        }

        public void setSaddress(String saddress) {
                this.saddress = saddress;
        }

        public Integer getSage() {
                return sage;
        }

        public void setSage(Integer sage) {
                this.sage = sage;
        }


}

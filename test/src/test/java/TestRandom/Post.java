package TestRandom;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    public String errors;
    public ArrayList<Result> results = new ArrayList<>();
    public Info info;

    static class Result {
        public String gender;
        public Name name;
        public Location location;
        public String email;
        public Login login;
        public Dob dob;
        public Registered registered;
        public String phone;
        public String cell;
        public Id id;
        public Picture picture;
        public String nat;


        static class Name {
            public String title;
            public String first;
            public String last;
        }


        static class Location {
            public Street street;
            public String city;
            public String state;
            public String country;
            public String postcode;
            public Coordinates coordinates;
            public Timezone timezone;

            static class Street {
                public int number;
                public String name;
            }

            static class Coordinates {
                public String latitude;
                public String longitude;
            }

            static class Timezone{
                public String offset;
                public String description;
            }

        }


        static class Login {
            public String uuid;
            public String username;
            public String password;
            public String salt;
            public String md5;
            public String sha1;
            public String sha256;
        }

        static class Dob {
            public Date date;
            public int age;
        }


        static class Registered {
            public Date date;
            public int age;
        }

        static class Id {
            public String name;
            public String value;
        }


        static class Picture {
            public String large;
            public String medium;
            public String thumbnail;
        }


    }

    static class Info {
        public String seed;
        public int results;
        public int page;
        public String version;
    }


}
package jp.co.active.kenshu.q2_1;

import java.util.Calendar;

/**
 * java 演習課題Q2_1_生年月日から年齢・学校を出力するプログラム
 * @author yamamoto_ren
 */
public class PersonDisplayMain {
    public static void main(String[] args) {
        String birthday = args[0];
        PersonManager pm = new PersonManager();
        int age = pm.generate(birthday).getAge();
        String school = pm.generate(birthday).getSchool();

        System.out.println(age + "歳：" + school);

    }

    class Person {
        private int age;
        private String school;

        //コンストラクター
        public Person(int age, String school) {
            super();
            this.age = age;
            this.school = school;
        }

        public int getAge() {
            return age;
        }

        public String getSchool() {
            return school;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setSchool(String school) {
            this.school = school;
        }

    }

    class PersonManager {
        public Person generate(String birthday) {

            Calendar calendar = Calendar.getInstance();

            int birthYear = Integer.parseInt(birthday.substring(0, 4));
            int birthMonth = Integer.parseInt(birthday.substring(4, 6));
            int birthDay = Integer.parseInt(birthday.substring(6, 8));

            String calcuSchool = null;

            int calcuAge = calendar.get(Calendar.YEAR) - birthYear;
            if (birthMonth > calendar.get(Calendar.MONTH)) {
                calcuAge -= 1;
            } else if (birthMonth == calendar.get(Calendar.MONTH)) {
                if (birthDay > calendar.get(Calendar.DATE)) {
                    calcuAge -= 1;
                }
            }

            if (calcuAge <= 6) {
                calcuSchool = "児童";
            } else if (6 < calcuAge && calcuAge <= 12) {
                calcuSchool = "小学生";
            } else if (12 < calcuAge && calcuAge <= 15) {
                calcuSchool = "中学生";
            } else if (15 < calcuAge && calcuAge <= 18) {
                calcuSchool = "高校生";
            } else if (18 < calcuAge && calcuAge <= 22) {
                calcuSchool = "大学生";
            } else if (22 < calcuAge) {
                calcuSchool = "社会人";
            }

            Person person = new Person(calcuAge, calcuSchool);
            return person;
        }
    }
}
package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name , balance ,5000);
        this.tradeLicenseId = tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {

        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        //EX : LicenseId : A A A B B C D

        String ans = valideLicense(tradeLicenseId);

        if (ans.equals("")) {

            throw  new Exception("Valid License can not be generated");
        }
        else{
            tradeLicenseId = ans;//update the licenseId
        }

    }

    String valideLicense(String tradeLicenseId) {

        // Time Complexity  : O(N)
        // space Complexity : o(N)

        int freq[] = new int[26];

        for(int i = 0 ;i < tradeLicenseId.length() ;i++){

            char ch = tradeLicenseId.charAt(i);

            freq[ch-'A']++;//tradeLicenseId have only uppercaseLetters
        }


        StringBuilder sb = new StringBuilder();

        int j = 0;

        while(j < tradeLicenseId.length()) {

            // find the first - highest freq element and second-highest freq element

            int firstMax    = -1;
            int firstMaxIdx = -1;

            int secondMax    = -1;
            int secondMaxIdx = -1;


            for(int i = 0 ; i < 26 ;i++){


                if(freq[i] > 0) {

                    if(freq[i] > firstMax) {

                        secondMax = firstMax;//update the secondMax first

                        secondMaxIdx = firstMaxIdx;//update the secondMax first

                        firstMax = freq[i];

                        firstMaxIdx = i;

                    }
                    else if(freq[i] > secondMax) { // check for secondMax condition

                        secondMaxIdx = i;
                        secondMax   = freq[i];
                    }
                }
            }

            if(firstMaxIdx != -1 && secondMaxIdx != -1) {

                char ch1 = (char) (firstMaxIdx + 65);
                char ch2 = (char) (secondMaxIdx + 65);

                freq[firstMaxIdx]--;
                freq[secondMaxIdx]--;

                sb.append(ch1);//append the firstMax fre character
                sb.append(ch2);//append the secondMax fre character
            }

            else if(firstMaxIdx != -1){ // if there is only  single character
                char ch1 =( char) (firstMaxIdx + 65);

                freq[firstMaxIdx]--;

                sb.append(ch1);
            }

            else break;

            if(sb.length() > 1){ // if the single character was repeated multiple times they are may be matched
                int l= sb.length();

                if(sb.charAt(l-1) == sb.charAt(l-2)) return "";
            }

            j++;
        }

        return sb.toString();
    }
}


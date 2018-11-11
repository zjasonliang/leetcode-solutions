public class StringtoInteger {
    public static int myAtoi(String str) {
        boolean start = false;
        boolean sign = true;
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '-':
                    if (start)
                        return 0;
                    else {
                        start = true;
                        sign = false;
                    }
                    break;
                case '0':
                    if (sign) {
                        if (sum * 10 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10;
                    } else {
                        if (sum * 10 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10;
                    }
                    break;

                case '1':
                    if (sign) {
                        if (sum * 10 + 1 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 1;
                    } else {
                        if (sum * 10 - 1 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 1;
                    }
                    break;

                case '2':
                    if (sign) {
                        if (sum * 10 + 2 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 2;
                    } else {
                        if (sum * 10 - 2 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 2;
                    }
                    break;

                case '3':
                    if (sign) {
                        if (sum * 10 + 3 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 3;
                    } else {
                        if (sum * 10 - 3 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 3;
                    }
                    break;

                case '4':
                    if (sign) {
                        if (sum * 10 + 4 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 4;
                    } else {
                        if (sum * 10 - 4 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 4;
                    }
                    break;

                case '5':
                    if (sign) {
                        if (sum * 10 + 5 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 5;
                    } else {
                        if (sum * 10 - 5 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 5;
                    }
                    break;

                case '6':
                    if (sign) {
                        if (sum * 10 + 6 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 6;
                    } else {
                        if (sum * 10 - 6 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 6;
                    }
                    break;

                case '7':
                    if (sign) {
                        if (sum * 10 + 7 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 7;
                    } else {
                        if (sum * 10 - 7 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 7;
                    }
                    break;

                case '8':
                    if (sign) {
                        if (sum * 10 + 8 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 8;
                    } else {
                        if (sum * 10 - 8 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 8;
                    }
                    break;

                case '9':
                    if (sign) {
                        if (sum * 10 + 9 < 0) {
                            sum = Integer.MAX_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 + 9;
                    } else {
                        if (sum * 10 - 9 > 0) {
                            sum = Integer.MIN_VALUE;
                            return sum;
                        }
                        else
                            sum = sum * 10 - 9;
                    }
                    break;

                case ' ':
                    if (start)
                        return sum;
                    break;

                default:
                    return sum;

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-9128344432"));
    }
}

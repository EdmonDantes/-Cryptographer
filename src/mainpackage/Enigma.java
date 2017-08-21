//Author - Dantes2104

package mainpackage;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Enigma {
	
	public static String encode(String text,String key,String reflectors)throws MyException{
		int[] rotors = strtoint(key);
		if (rotors.length > 10){
			throw new MyException(1);
		}
		if (rotors.length < 1){
			throw new MyException(2);
		}
		List<Reflector> l = new ArrayList<Reflector>();
		if (reflectors.length() > 2){
			l = getRefl(reflectors);
		}
		String local ="";
		int indexr1 = rotors[0];
		int indexr2 = -1;
		int indexr3 = -1;
		int indexr4 = -1;
		int indexr5 = -1;
		int indexr6 = -1;
		int indexr7 = -1;
		int indexr8 = -1;
		int indexr9 = -1;
		int indexr10 = -1;
		try{
			indexr2 = rotors[1];
			indexr3 = rotors[2];
			indexr4 = rotors[3];
		    indexr5 = rotors[4];
			indexr6 = rotors[5];
			indexr7 = rotors[6];
			indexr8 = rotors[7];
		    indexr9 = rotors[8];
		    indexr10 = rotors[9];
		}catch(Exception e){
			
		}
		for (int i = 0;i<text.length();i++){
			indexr1++;
			if (indexr2 > -1){
				indexr2+= (indexr1 /(i+1) );
			}
			if (indexr3 > -1){
				indexr3+= (indexr2 / (i+1));
			}
			if (indexr4 > -1){
				indexr4 += (indexr3/(i+1));
			}
			if (indexr5 > -1){
				indexr5 += (indexr4/(i+1));
			}
			if (indexr6 > -1){
				indexr6 += (indexr5/(i+1));
			}
			if (indexr7 > -1){
				indexr7 += (indexr6/(i+1));
			}
			if (indexr8 > -1){
				indexr8 += (indexr7/(i+1));
			}
			if (indexr9 > -1){
				indexr9 += (indexr8/(i+1));
			}
			if (indexr10 > -1){
				indexr10 += (indexr9/(i+1));
			}
			
			
			int y = getr1(getId(text.charAt(i)),indexr1);
			if (indexr2 > -1){
				y = getr2(y,indexr2);
			}
			if (indexr3 > -1){
				y = getr3(y,indexr3);
			}
			if (indexr4 > -1){
				y = getr4(y,indexr4);
			}
			if (indexr5 > -1){
				y = getr5(y,indexr5);
			}
			if (indexr6 > -1){
				y = getr6(y,indexr6);
			}
			if (indexr7 > -1){
				y = getr7(y,indexr7);
			}
			if (indexr8 > -1){
				y = getr8(y,indexr8);
			}
			if (indexr9 > -1){
				y = getr9(y,indexr9);
			}
			if (indexr10 > -1){
				y = getr10(y,indexr10);
			}
			local += getChar(encodeRefl(l,y));
		}
		return local;
	}
	
	public static String decode(String text,String key,String reflectors) throws MyException{
		int[] rotors = strtoint(key);
		if (rotors.length > 10){
			throw new MyException(1);
		}
		if (rotors.length < 1){
			throw new MyException(2);
		}
		List<Reflector> l;
		if (reflectors.length() > 2){
			l = getRefl(reflectors);
		}else{
			l = new ArrayList<Reflector>();
		}
		String local = "";
		int indexr1 = rotors[0];
		int indexr2 = -1;
		int indexr3 = -1;
		int indexr4 = -1;
		int indexr5 = -1;
		int indexr6 = -1;
		int indexr7 = -1;
		int indexr8 = -1;
		int indexr9 = -1;
		int indexr10 = -1;
		try{
			indexr2 = rotors[1];
			indexr3 = rotors[2];
			indexr4 = rotors[3];
		    indexr5 = rotors[4];
			indexr6 = rotors[5];
			indexr7 = rotors[6];
			indexr8 = rotors[7];
		    indexr9 = rotors[8];
		    indexr10 = rotors[9];
		}catch(Exception e){
			
		}
		for (int i = 0;i<text.length();i++){
			indexr1++;
			if (indexr2 > -1){
				indexr2+= (indexr1 /(i+1) );
			}
			if (indexr3 > -1){
				indexr3+= (indexr2 / (i+1));
			}
			if (indexr4 > -1){
				indexr4 += (indexr3/(i+1));
			}
			if (indexr5 > -1){
				indexr5 += (indexr4/(i+1));
			}
			if (indexr6 > -1){
				indexr6 += (indexr5/(i+1));
			}
			if (indexr7 > -1){
				indexr7 += (indexr6/(i+1));
			}
			if (indexr8 > -1){
				indexr8 += (indexr7/(i+1));
			}
			if (indexr9 > -1){
				indexr9 += (indexr8/(i+1));
			}
			if (indexr10 > -1){
				indexr10 += (indexr9/(i+1));
			}
			
			
			
			int y = decodeRefl(l,getId(text.charAt(i)));
			if (indexr10 > -1){
				y = ungetr10(y,indexr10);
			}
			if (indexr9 > -1){
				y = ungetr9(y,indexr9);
			}
			if (indexr8 > -1){
				y = ungetr8(y,indexr8);
			}
			if (indexr7 > -1){
				y = ungetr7(y,indexr7);
			}
			if (indexr6 > -1){
				y = ungetr6(y,indexr6);
			}
			if (indexr5 > -1){
				y = ungetr5(y,indexr5);
			}
			if (indexr4 > -1){
				y = ungetr4(y,indexr4);
			}
			if (indexr3 > -1){
				y = ungetr3(y,indexr3);
			}
			if (indexr2 > -1){
				y = ungetr2(y,indexr2);
			}
			local += getChar(ungetr1(y,indexr1));
			
		}
		return local;
	}
	
	public static String getRandomreflectors(){
		Random r = new Random();
		String str = "";
		for (int i = 0;i<20;i++){
			String local = "";
			for (int j = 0;j<2;j++){
				local += getChar(r.ints(11, 63).iterator().next());
			}
			local += ";";
		str += local;
		}
		return str;
	}
	
	public static String getRandomKey() throws UnsupportedEncodingException{
		Random r = new Random();
		byte[] b = new byte[10];
		getBytes(r,b);
		return new String(b,"UTF-8");
	}
	
	public static void getBytes(Random r,byte[] s){
		for (int i = 0;i<s.length;i++){
			int l = 0;
			do{
				l = r.nextInt();
			}while(((byte) l) < 0);
			s[i] = (byte) l;
		}
	}
	
	private static int[] strtoint(String str){
		int[] ret = new int[str.length()];
		for (int i = 0;i<str.length();i++){
			ret[i] = (int) str.charAt(i);
		}
		return ret;
	}
	
	private static char getChar(int id){
		switch (id){
			default:return'↓';
			case 1:return' ';
			case 2:return'.';
			case 3:return',';
			case 4:return'-';
			case 5:return'?';
			case 6:return'!';
			case 7:return':';
			case 8:return';';
			case 9:return'\'';
			case 10:return'\"';
			case 11:return'A';
			case 12:return'a';
			case 13:return'B';
			case 14:return'b';
			case 15:return'C';
			case 16:return'c';
			case 17:return'D';
			case 18:return'd';
			case 19:return'E';
			case 20:return'e';
			case 21:return'F';
			case 22:return'f';
			case 23:return'G';
			case 24:return'g';
			case 25:return'H';
			case 26:return'h';
			case 27:return'I';
			case 28:return'i';
			case 29:return'J';
			case 30:return'j';
			case 31:return'K';
			case 32:return'k';
			case 33:return'L';
			case 34:return'l';
			case 35:return'M';
			case 36:return'm';
			case 37:return'N';
			case 38:return'n';
			case 39:return'O';
			case 40:return'o';
			case 41:return'P';
			case 42:return'p';
			case 43:return'Q';
			case 44:return'q';
			case 45:return'R';
			case 46:return'r';
			case 47:return'S';
			case 48:return's';
			case 49:return'T';
			case 50:return't';
			case 51:return'U';
			case 52:return'u';
			case 53:return'V';
			case 54:return'v';
			case 55:return'W';
			case 56:return'w';
			case 57:return'X';
			case 58:return'x';
			case 59:return'Y';
			case 60:return'y';
			case 61:return'Z';
			case 62:return'z';
			case 63:return'А';
			case 64:return'а';
			case  65:return'Б';
			case  66:return'б';
			case 67 :return'В';
			case 68 :return'в';
			case 69 :return'Г';
			case 70 :return'г';
			case 71 :return'Д';
			case 72 :return'д';
			case 73 :return'Е';
			case 74 :return'е';
			case 75 :return'Ё';
			case 76:return'ё';
			case 77 :return'Ж';
			case 78 :return'ж';
			case 79 :return'З';
			case 80 :return'з';
			case 81 :return'И';
			case 82 :return'и';
			case 83 :return'Й';
			case 84 :return'й';
			case 85 :return'К';
			case 86 :return'к';
			case 87 :return'Л';
			case 88 :return'л';
			case 89 :return'М';
			case 90 :return'м';
			case 91 :return'Н';
			case 92 :return'н';
			case 93 :return'О';
			case 94 :return'о';
			case 95 :return'П';
			case 96 :return'п';
			case 97 :return'Р';
			case 98 :return'р';
			case 99 :return'С';
			case 100 :return'с';
			case 101 :return'Т';
			case 102 :return'т';
			case 103 :return'У';
			case 104 :return'у';
			case 105 :return'Ф';
			case 106 :return'ф';
			case 107 :return'Х';
			case 108 :return'х';
			case 109 :return'Ц';
			case 110 :return'ц';
			case 111 :return'Ч';
			case 112 :return'ч';
			case 113 :return'Ш';
			case 114 :return'ш';
			case 115 :return'Щ';
			case 116 :return'щ';
			case 117 :return'Ъ';
			case 118 :return'ъ';
			case 119 :return'Ы';
			case 120 :return'ы';
			case 121 :return'Ь';
			case 122 :return'ь';
			case 123 :return'Э';
			case 124 :return'э';
			case 125 :return'Ю';
			case 126 :return'ю';
			case 127 :return'Я';
			case 128 :return'я';
			case 129 :return'0';
			case 130 :return'1';
			case 131 :return'2';
			case 132 :return'3';
			case 133 :return'4';
			case 134 :return'5';
			case 135 :return'6';
			case 136 :return'7';
			case 137 :return'8';
			case 138 :return'9';
			case 139 :return'\\';
			case 140 :return'/';
			case 141 :return'|';
			case 142 :return'+';
			case 143 :return'@';
			case 144 :return'%';
			case 145 :return'^';
			case 146 :return'&';
			case 147 :return'*';
			case 148 :return'=';
			case 149 :return'È';
			case 150 :return'è';
			case 151 :return'É';
			case 152 :return'é';
			case 153: return'Ê';
			case 154: return'ê';
			case 155: return'Ç';
			case 156: return'ç';
			case 157:return'À';
			case 158:return'à';
			case 159:return'Á';
			case 160:return'á';
			case 161:return'Â';
			case 162:return'â';
			case 163:return'Ä';
			case 164:return'ä';
			case 165:return'Ò';
			case 166:return'ò';
			case 167:return'Ó';
			case 168:return'ó';
			case 169:return'Ô';
			case 170:return'ô';
			case 171:return'Ö';
			case 172:return'ö';
			case 173:return'Ø';
			case 174:return'ø';
			case 175:return'#';
			case 176:return'№';
			case 177:return'Ù';
			case 178:return'ù';
			case 179:return'Ú';
			case 180:return'ú';
			case 181:return'Û';
			case 182:return'û';
			case 183:return'Ü';
			case 184:return'ü';
			case 185:return'Ć';
			case 186:return'ć';
			case 187:return'Ĉ';
			case 188:return'ĉ';
		}
	}
	
	private static int getId(char a){
		switch (a){
			default:return 0;
			case ' ': return 1;
			case '.':return 2;
			case ',':return 3;
			case '-':return 4;
			case '?':return 5;
			case '!':return 6;
			case ':':return 7;
			case ';':return 8;
			case '\'':return 9;
			case '\"':return 10;
			case 'A':return 11;
			case 'a':return 12;
			case 'B':return 13; 
			case 'b':return 14;
			case 'C':return 15;
			case 'c':return 16;
			case 'D':return 17;
			case 'd':return 18;
			case 'E':return 19;
			case 'e':return 20;
			case 'F':return 21;
			case 'f':return 22;
			case 'G':return 23;
			case 'g':return 24;
			case 'H':return 25;
			case 'h':return 26;
			case 'I':return 27;
			case 'i':return 28;
			case 'J':return 29;
			case 'j':return 30;
			case 'K':return 31;
			case 'k':return 32;
			case 'L':return 33;
			case 'l':return 34;
			case 'M':return 35;
			case 'm':return 36;
			case 'N':return 37;
			case 'n':return 38;
			case 'O':return 39;
			case 'o':return 40;
			case 'P':return 41;
			case 'p':return 42;
			case 'Q':return 43;
			case 'q':return 44;
			case 'R':return 45;
			case 'r':return 46;
			case 'S':return 47;
			case 's':return 48;
			case 'T':return 49;
			case 't':return 50;
			case 'U':return 51;
			case 'u':return 52;
			case 'V':return 53;
			case 'v':return 54;
			case 'W':return 55;
			case 'w':return 56;
			case 'X':return 57;
			case 'x':return 58;
			case 'Y':return 59;
			case 'y':return 60;
			case 'Z':return 61;
			case 'z':return 62;
			case 'А':return 63;
			case 'а':return 64;
			case 'Б':return 65;
			case 'б':return 66;
			case 'В':return 67;
			case 'в':return 68;
			case 'Г':return 69;
			case 'г':return 70;
			case 'Д':return 71;
			case 'д':return 72;
			case 'Е':return 73;
			case 'е':return 74;
			case 'Ё':return 75;
			case 'ё':return 76;
			case 'Ж':return 77;
			case 'ж':return 78;
			case 'З':return 79;
			case 'з':return 80;
			case 'И':return 81;
			case 'и':return 82;
			case 'Й':return 83;
			case 'й':return 84;
			case 'К':return 85;
			case 'к':return 86;
			case 'Л':return 87;
			case 'л':return 88;
			case 'М':return 89;
			case 'м':return 90;
			case 'Н':return 91;
			case 'н':return 92;
			case 'О':return 93;
			case 'о':return 94;
			case 'П':return 95;
			case 'п':return 96;
			case 'Р':return 97;
			case 'р':return 98;
			case 'С':return 99;
			case 'с':return 100;
			case 'Т':return 101;
			case 'т':return 102;
			case 'У':return 103;
			case 'у':return 104;
			case 'Ф':return 105;
			case 'ф':return 106;
			case 'Х':return 107;
			case 'х':return 108;
			case 'Ц':return 109;
			case 'ц':return 110;
			case 'Ч':return 111;
			case 'ч':return 112;
			case 'Ш':return 113;
			case 'ш':return 114;
			case 'Щ':return 115;
			case 'щ':return 116;
			case 'Ъ':return 117;
			case 'ъ':return 118;
			case 'Ы':return 119;
			case 'ы':return 120;
			case 'Ь':return 121;
			case 'ь':return 122;
			case 'Э':return 123;
			case 'э':return 124;
			case 'Ю':return 125;
			case 'ю':return 126;
			case 'Я':return 127;
			case 'я':return 128;
			case '0':return 129;
			case '1':return 130;
			case '2':return 131;
			case '3':return 132;
			case '4':return 133;
			case '5':return 134;
			case '6':return 135;
			case '7':return 136;
			case '8':return 137;
			case '9':return 138;
			case '\\':return 139;
			case '/':return 140;
			case '|':return 141;
			case '+':return 142;
			case '@':return 143;
			case '%':return 144;
			case '^':return 145;
			case '&':return 146;
			case '*':return 147;
			case '=':return 148;
			case 'È':return 149;
			case 'è':return 150;
			case 'É':return 151;
			case 'é':return 152;
			case 'Ê':return 153;
			case 'ê':return 154;
			case 'Ç':return 155;
			case 'ç':return 156;
			case 'À':return 157;
			case 'à':return 158;
			case 'Á':return 159;
			case 'á':return 160;
			case 'Â':return 161;
			case 'â':return 162;
			case 'Ä':return 163;
			case 'ä':return 164;
			case 'Ò':return 165;
			case 'ò':return 166;
			case 'Ó':return 167;
			case 'ó':return 168;
			case 'Ô':return 169;
			case 'ô':return 170;
			case 'Ö':return 171;
			case 'ö':return 172;
			case 'Ø':return 173;
			case 'ø':return 174;
			case '#':return 175;
			case '№':return 176;
			case 'Ù':return 177;
			case 'ù':return 178;
			case 'Ú':return 179;
			case 'ú':return 180;
			case 'Û':return 181;
			case 'û':return 181;
			case 'Ü':return 181;
			case 'ü':return 181;
			case 'Ć':return 181;
			case 'ć':return 181;
			case 'Ĉ':return 181;
			case 'ĉ':return 181;
		}
	}
	
	private final static int[] r1 = new int[]{8,7,9,1,4,2,5,6,3,10,20,19,32,31,36,35,22,21,34,33,24,23,
			18,17,44,43,54,53,62,61,38,37,50,49,40,39,56,55,60,59,
			26,25,58,57,52,51,48,47,42,41,12,11,28,27,14,13,46,45,
			16,15,30,29,
			//Русские буквы
			63,123,135,85,96,94,134,79,68,69,133,77,71,137,105,88,129,64,101,102,65,73,112,127,114,76,124,125,75,97,67,132,83,110,100,119,66,84,130,109,70,126,74,82,122,72,93,95,128,104,138,116,92,136,118,111,78,117,120,80,113,108,86,89,87,91,98,106,115,107,90,131,121,81,99,103,
			172,151,161,177,165,141,159,143,150,176,146,166,144,155,157,164,169,148,171,158,180,152,170,167,173,154,175,145,139,147,179,142,156,140,149,162,168,153,174,163,160,178,
	
	};
	private final static int[] r2 = new int[]{9,7,3,1,10,5,4,2,6,8,12,11,30,29,18,17,32,31,48,47,27,28,
			46,45,52,51,58,57,14,13,34,33,26,25,56,55,50,49,36,35,
			16,15,44,43,24,23,62,61,38,37,42,41,60,59,22,21,54,53,
			40,39,20,19,
			80,67,131,72,114,75,76,138,91,111,105,100,101,73,102,103,86,113,99,124,120,127,79,68,66,133,90,115,134,122,108,109,84,65,95,130,112,81,77,69,125,88,135,70,132,126,96,93,97,107,106,74,82,94,110,119,89,121,85,129,78,92,117,118,116,136,83,87,137,71,63,104,123,64,128,98,
			158,153,174,167,140,155,172,161,160,173,150,141,169,164,139,180,146,149,175,168,170,163,154,162,178,144,145,142,152,151,148,147,165,171,156,179,143,177,166,157,159,176,
	};
	private final static int[] r3 = new int[]{8,3,5,1,4,9,10,2,6,7,14,13,18,17,22,21,26,25,30,29,34,33,
			16,15,42,41,46,45,50,49,58,57,54,53,62,61,38,37,60,59,
			20,19,28,27,56,55,24,23,12,11,32,31,36,35,52,51,48,47,
			44,43,40,39,
			87,109,64,76,90,137,112,74,116,138,70,66,120,97,81,92,135,103,123,126,131,67,134,84,106,80,79,86,69,83,129,78,93,102,63,111,75,133,77,132,99,85,128,68,130,118,107,101,100,91,115,127,98,96,94,113,114,95,125,119,73,121,89,122,71,82,105,136,117,108,110,72,124,65,88,104,
			168,155,143,170,174,147,161,140,159,178,146,169,149,139,165,158,154,157,160,153,175,145,163,150,148,173,172,162,180,176,156,164,144,152,166,171,177,167,141,179,151,142,
	};
	private final static int[] r4 = new int[]{6,10,5,8,2,7,9,3,4,1,20,19,48,47,40,39,54,53,42,41,62,61,
			30,29,12,11,60,59,44,43,52,51,28,27,46,45,26,25,58,57,
			34,33,38,37,22,21,50,49,24,23,32,31,18,17,16,15,36,35,
			56,55,14,13,
			118,117,91,128,79,87,124,131,74,95,80,115,78,68,126,76,99,138,85,105,70,94,127,104,90,134,103,83,130,66,116,100,71,86,63,120,81,133,72,109,113,106,93,125,123,77,92,136,88,114,84,67,112,82,107,132,110,97,98,137,111,75,119,102,121,89,64,101,73,135,65,122,69,96,129,108,
			140,173,146,171,152,151,176,179,160,149,164,143,175,144,178,177,158,168,150,147,165,145,155,154,157,174,169,142,156,163,166,159,180,161,172,141,170,139,153,148,162,167,
	};
	
	private final static int[] r5 = new int[]{8,6,3,9,4,10,7,1,5,2,53,54,61,62,13,14,45,46,23,24,27,28,
			49,50,59,60,51,52,41,42,47,48,17,18,37,38,25,26,33,34,
			57,58,11,12,55,56,35,36,29,30,43,44,39,40,21,22,19,20,
			15,16,31,32,
			110,135,80,77,69,91,134,106,97,117,74,101,122,103,102,87,84,107,109,137,72,112,76,93,99,111,127,70,121,88,75,116,105,114,67,95,66,71,125,89,73,133,83,98,96,138,78,113,132,64,94,92,115,86,119,120,81,79,100,68,65,128,85,123,90,118,82,124,130,131,108,136,126,63,129,104,
			150,143,179,173,142,149,166,165,145,140,152,141,159,151,174,146,144,168,178,171,170,147,161,177,156,155,167,148,175,160,157,172,180,154,164,153,162,139,158,169,163,176,
	};
	
	private final static int[] r6 = new int[]{9,3,10,2,6,7,5,8,4,1,29,30,41,42,23,24,53,54,39,40,51,52,
			35,36,21,22,59,60,43,44,13,14,19,20,37,38,25,26,61,62,
			45,46,17,18,31,32,11,12,47,48,57,58,33,34,27,28,15,16,
			49,50,55,56,
			97,115,77,138,110,132,119,121,67,85,133,91,137,103,122,81,71,136,86,90,114,135,63,126,128,120,70,109,72,82,96,80,111,76,117,89,101,124,130,116,64,113,84,68,125,105,79,99,100,69,94,83,118,127,123,108,74,129,75,131,66,134,102,95,65,92,93,98,73,78,104,107,87,106,112,88,
			159,161,146,163,150,149,154,166,160,151,172,173,141,144,140,145,180,168,170,164,148,175,153,171,139,179,176,152,158,178,157,174,162,155,147,156,142,167,143,169,177,165,
	};
	
	private final static int[] r7 = new int[]{7,4,6,1,2,9,3,10,8,5,37,38,61,62,29,30,25,26,23,24,45,46,
			15,16,57,58,35,36,59,60,47,48,55,56,13,14,39,40,51,52,
			21,22,11,12,27,28,53,54,33,34,41,42,19,20,31,32,43,44,
			17,18,49,50,
			94,88,107,92,123,91,72,65,71,124,114,73,115,86,132,122,131,84,137,90,112,102,103,136,120,118,82,100,74,80,127,70,98,125,109,134,63,101,96,104,129,87,111,77,130,79,121,113,97,76,95,69,83,99,89,85,119,116,117,110,126,67,93,68,138,81,108,128,105,75,78,135,64,106,66,133,
			149,159,161,163,147,142,174,158,156,150,171,166,146,155,144,176,139,148,151,175,153,160,141,170,167,140,152,172,169,180,165,154,179,145,177,143,157,178,162,168,164,173,
	};
	
	private final static int[] r8 = new int[]{2,4,5,9,8,7,6,10,1,3,21,22,31,32,43,44,25,26,49,50,33,34,
			57,58,39,40,15,16,13,14,29,30,47,48,41,42,17,18,61,62,
			45,46,11,12,35,36,19,20,55,56,37,38,27,28,51,52,59,60,
			23,24,53,54,
			69,113,87,88,95,97,121,108,123,74,76,133,84,98,125,85,65,96,114,72,83,68,117,75,120,127,80,105,109,100,77,67,102,137,79,112,111,82,99,136,138,94,78,71,119,106,128,131,104,107,66,124,90,70,115,110,63,126,86,118,134,130,103,116,122,81,93,64,101,91,129,73,135,92,132,89,
			139,147,166,165,149,172,180,161,144,145,178,177,146,171,164,160,157,168,140,169,174,150,148,176,156,152,167,155,141,162,154,179,153,175,151,163,143,159,158,170,142,173,
				
	};
	
	private final static int[] r9 = new int[]{8,2,5,7,3,6,9,1,4,10,33,34,19,20,59,60,29,30,53,54,15,16,
			37,38,27,28,57,58,55,56,41,42,13,14,43,44,35,36,17,18,
			45,46,49,50,11,12,31,32,61,62,23,24,21,22,51,52,25,26,
			39,40,47,48,
			101,130,132,67,107,81,99,75,86,119,104,120,93,112,125,100,113,92,116,109,115,131,123,63,79,138,72,118,84,71,69,103,128,73,134,106,98,95,94,70,135,110,114,108,121,102,137,136,64,77,97,66,91,82,133,87,90,96,124,68,111,105,65,80,122,126,88,117,85,83,76,74,127,129,89,78,
			154,175,153,179,160,143,167,163,146,180,170,172,139,162,140,178,148,164,147,156,157,159,144,145,168,173,142,174,161,177,150,176,158,152,155,171,169,166,149,165,141,151,
	};
	
	private final static int[] r10 = new int[]{4,1,8,6,10,9,2,5,3,7,21,22,47,48,39,40,31,32,11,12,37,38,
			51,52,19,20,45,46,25,26,35,36,13,14,49,50,27,28,59,60,
			15,16,55,56,33,34,43,44,41,42,61,62,57,58,53,54,23,24,
			29,30,17,18,
			110,101,109,63,133,86,66,104,111,71,76,84,135,120,103,74,79,98,99,108,129,114,68,75,121,102,118,137,112,127,95,91,64,130,87,90,117,115,73,80,92,105,116,134,65,72,119,131,96,106,70,124,126,67,136,132,97,122,113,89,85,125,77,83,123,94,93,100,107,138,69,128,78,82,88,81,
			175,142,152,167,166,178,164,145,169,141,177,176,144,151,165,170,149,153,139,156,146,160,162,158,171,159,140,179,155,157,168,150,163,161,143,172,180,147,154,173,174,148,
	};
	
	
	
	
	private static final int abs(int number){
		if (number >= 0){
			return number;
		}else{
			return -number;
		}
	} 
	
	private static final int getr1(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r1[local-1];
	}
	
	private static final int ungetr1(int id,int rotor){
		int local =search(r1, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr2(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r2[local-1];
	}
	
	private static final int ungetr2(int id,int rotor){
		int local =search(r2, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr3(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r3[local-1];
	}
	
	private static final int ungetr3(int id,int rotor){
		int local =search(r3, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr4(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r4[local-1];
	}
	
	private static final int ungetr4(int id,int rotor){
		int local =search(r4, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr5(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r5[local-1];
	}
	
	private static final int ungetr5(int id,int rotor){
		int local =search(r5, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr6(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r6[local-1];
	}
	
	private static final int ungetr6(int id,int rotor){
		int local =search(r6, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr7(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r7[local-1];
	}
	
	private static final int ungetr7(int id,int rotor){
		int local =search(r7, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr8(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r8[local-1];
	}
	
	private static final int ungetr8(int id,int rotor){
		int local =search(r8, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr9(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r9[local-1];
	}
	
	private static final int ungetr9(int id,int rotor){
		int local =search(r9, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	private static final int getr10(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 180){
			local -=179;
		}
		return r10[local-1];
	}
	
	private static final int ungetr10(int id,int rotor){
		int local =search(r10, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 179;
		}
		return local;
	}
	
	
	
	private static final int search(int[] a,int number){
		for (int i = 0;i<a.length;i++){
			if (a[i] == number){
				return i;
			}
		}
		return -1;
	}
	
	private final static List<Reflector> getRefl(String str){
		List<Reflector> ret = new ArrayList<Reflector>();
		String local = "";
		for (int i = 0;i<str.length();i++){
			if (str.charAt(i) == ';'){
				if (local.length() > 1){
					local = local.toLowerCase();
					char l1 = local.charAt(0);
					char l2 = local.charAt(1);
					local =local.toUpperCase();
					char b1 = local.charAt(0);
					char b2 = local.charAt(1);
					ret.add(new Reflector(getId(l1),getId(l2),getId(b1),getId(b2)));	
				}
				local = "";
			}else{
				local+=str.charAt(i);
			}
		}
		return ret;
	}
	
	private final static int encodeRefl(List<Reflector> refl,int id){
		int local = id;
		for (int i = 0;i<refl.size();i++){
			local = refl.get(i).encode(local);
		}
		return local;
	}
	
	private final static int decodeRefl(List<Reflector> refl,int id){
		int local = id;
		for (int i = refl.size()-1;i>-1;i--){
			local = refl.get(i).encode(local);
		}
		return local;
	}
	
	private final static class Reflector{
		private int on = 0;
		private int on_big = 0;
		private int to = 0;
		private int to_big = 0;
		public Reflector(int id_on,int in_to,int id_on_big,int id_to_big){
			if (id_on > 10 && in_to > 10 && id_on_big > 10 && id_to_big > 10){
				on = id_on;
				to = in_to;
				on_big = id_on_big;
				to_big = id_to_big;
			}else
			{
				to = on_big = to_big = on = -1;
			}
		}
		
		public int encode(int id){
			if (id == on){
				return to;
			}
			if (id == to){
				return on;
			}
			if (id == on_big){
				return to_big;
			}
			if (id == to_big){
				return on_big;
			}
			
			else{
				return id;
			}
		}
		
		
	}
	
}

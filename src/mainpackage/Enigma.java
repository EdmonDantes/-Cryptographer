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
		switch(id){
		default:return'■';
		case 1 : return' ';
		case 2 : return'.';
		case 3 : return',';
		case 4 : return'-';
		case 5 : return'+';
		case 6 : return'?';
		case 7 : return'!';
		case 8 : return':';
		case 9 : return';';
		case 10 : return'<';
		case 11 : return'>';
		case 12 : return'/';
		case 13 : return'\\';
		case 14 : return'\'';
		case 15 : return'\"';
		case 16 : return'[';
		case 17 : return']';
		case 18 : return'{';
		case 19 : return'}';
		case 20 : return'|';
		case 21 : return'@';
		case 22 : return'#';
		case 23 : return'№';
		case 24 : return'$';
		case 25 : return'%';
		case 26 : return'^';
		case 27 : return'&';
		case 28 : return'*';
		case 29 : return'(';
		case 30 : return')';
		case 31 : return'=';
		case 32 : return'A';
		case 33 : return'a';
		case 34 : return'B';
		case 35 : return'b';
		case 36 : return'C';
		case 37 : return'c';
		case 38 : return'D';
		case 39 : return'd';
		case 40 : return'E';
		case 41 : return'e';
		case 42 : return'F';
		case 43 : return'f';
		case 44 : return'G';
		case 45 : return'g';
		case 46 : return'H';
		case 47 : return'h';
		case 48 : return'I';
		case 49 : return'i';
		case 50 : return'J';
		case 51 : return'j';
		case 52 : return'K';
		case 53 : return'k';
		case 54 : return'L';
		case 55 : return'l';
		case 56 : return'M';
		case 57 : return'm';
		case 58 : return'N';
		case 59 : return'n';
		case 60 : return'O';
		case 61 : return'o';
		case 62 : return'P';
		case 63 : return'p';
		case 64 : return'Q';
		case 65 : return'q';
		case 66 : return'R';
		case 67 : return'r';
		case 68 : return'S';
		case 69 : return's';
		case 70 : return'T';
		case 71 : return't';
		case 72 : return'U';
		case 73 : return'u';
		case 74 : return'V';
		case 75 : return'v';
		case 76 : return'W';
		case 77 : return'w';
		case 78 : return'X';
		case 79 : return'x';
		case 80 : return'Y';
		case 81 : return'y';
		case 82 : return'Z';
		case 83 : return'z';
		case 84 : return'А';
		case 85 : return'а';
		case 86 : return'Б';
		case 87 : return'б';
		case 88 : return'В';
		case 89 : return'в';
		case 90 : return'Г';
		case 91 : return'г';
		case 92 : return'Д';
		case 93 : return'д';
		case 94 : return'Е';
		case 95 : return'е';
		case 96 : return'Ё';
		case 97 : return'ё';
		case 98 : return'Ж';
		case 99 : return'ж';
		case 100 : return'З';
		case 101 : return'з';
		case 102 : return'И';
		case 103 : return'и';
		case 104 : return'Й';
		case 105 : return'й';
		case 106 : return'К';
		case 107 : return'к';
		case 108 : return'Л';
		case 109 : return'л';
		case 110 : return'М';
		case 111 : return'м';
		case 112 : return'Н';
		case 113 : return'н';
		case 114 : return'О';
		case 115 : return'о';
		case 116 : return'П';
		case 117 : return'п';
		case 118 : return'Р';
		case 119 : return'р';
		case 120 : return'С';
		case 121 : return'с';
		case 122 : return'Т';
		case 123 : return'т';
		case 124 : return'У';
		case 125 : return'у';
		case 126 : return'Ф';
		case 127 : return'ф';
		case 128 : return'Х';
		case 129 : return'х';
		case 130 : return'Ц';
		case 131 : return'ц';
		case 132 : return'Ч';
		case 133 : return'ч';
		case 134 : return'Ш';
		case 135 : return'ш';
		case 136 : return'Щ';
		case 137 : return'щ';
		case 138 : return'Ъ';
		case 139 : return'ъ';
		case 140 : return'Ы';
		case 141 : return'ы';
		case 142 : return'Ь';
		case 143 : return'ь';
		case 144 : return'Э';
		case 145 : return'э';
		case 146 : return'Ю';
		case 147 : return'ю';
		case 148 : return'Я';
		case 149 : return'я';
		case 150 : return'0';
		case 151 : return'1';
		case 152 : return'2';
		case 153 : return'3';
		case 154 : return'4';
		case 155 : return'5';
		case 156 : return'6';
		case 157 : return'7';
		case 158 : return'8';
		case 159 : return'9';
		case 160 : return'È';
		case 161 : return'è';
		case 162 : return'É';
		case 163 : return'é';
		case 164 : return'Ê';
		case 165 : return'ê';
		case 166 : return'Ç';
		case 167 : return'ç';
		case 168 : return'À';
		case 169 : return'à';
		case 170 : return'Á';
		case 171 : return'á';
		case 172 : return'Â';
		case 173 : return'â';
		case 174 : return'Ä';
		case 175 : return'ä';
		case 176 : return'Ò';
		case 177 : return'ò';
		case 178 : return'Ó';
		case 179 : return'ó';
		case 180 : return'Ô';
		case 181 : return'ô';
		case 182 : return'Ö';
		case 183 : return'ö';
		case 184 : return'Ø';
		case 185 : return'ø';
		case 186 : return'Ù';
		case 187 : return'ù';
		case 188 : return'Ú';
		case 189 : return'ú';
		case 190 : return'Û';
		case 191 : return'û';
		case 192 : return'Ü';
		case 193 : return'ü';
		case 194 : return'Ć';
		case 195 : return'ć';
		case 196 : return'Ĉ';
		case 197 : return'ĉ';
		}
}
	
	private static int getId(char a){
		switch (a){
		default:return 0;
		case ' ':return 1;
		case '.':return 2;
		case ',':return 3;
		case '-':return 4;
		case '+':return 5;
		case '?':return 6;
		case '!':return 7;
		case ':':return 8;
		case ';':return 9;
		case '<':return 10;
		case '>':return 11;
		case '/':return 12;
		case '\\':return 13;
		case '\'':return 14;
		case '\"':return 15;
		case '[':return 16;
		case ']':return 17;
		case '{':return 18;
		case '}':return 19;
		case '|':return 20;
		case '@':return 21;
		case '#':return 22;
		case '№':return 23;
		case '$':return 24;
		case '%':return 25;
		case '^':return 26;
		case '&':return 27;
		case '*':return 28;
		case '(':return 29;
		case ')':return 30;
		case '=':return 31;
		case 'A':return 32;
		case 'a':return 33;
		case 'B':return 34;
		case 'b':return 35;
		case 'C':return 36;
		case 'c':return 37;
		case 'D':return 38;
		case 'd':return 39;
		case 'E':return 40;
		case 'e':return 41;
		case 'F':return 42;
		case 'f':return 43;
		case 'G':return 44;
		case 'g':return 45;
		case 'H':return 46;
		case 'h':return 47;
		case 'I':return 48;
		case 'i':return 49;
		case 'J':return 50;
		case 'j':return 51;
		case 'K':return 52;
		case 'k':return 53;
		case 'L':return 54;
		case 'l':return 55;
		case 'M':return 56;
		case 'm':return 57;
		case 'N':return 58;
		case 'n':return 59;
		case 'O':return 60;
		case 'o':return 61;
		case 'P':return 62;
		case 'p':return 63;
		case 'Q':return 64;
		case 'q':return 65;
		case 'R':return 66;
		case 'r':return 67;
		case 'S':return 68;
		case 's':return 69;
		case 'T':return 70;
		case 't':return 71;
		case 'U':return 72;
		case 'u':return 73;
		case 'V':return 74;
		case 'v':return 75;
		case 'W':return 76;
		case 'w':return 77;
		case 'X':return 78;
		case 'x':return 79;
		case 'Y':return 80;
		case 'y':return 81;
		case 'Z':return 82;
		case 'z':return 83;
		case 'А':return 84;
		case 'а':return 85;
		case 'Б':return 86;
		case 'б':return 87;
		case 'В':return 88;
		case 'в':return 89;
		case 'Г':return 90;
		case 'г':return 91;
		case 'Д':return 92;
		case 'д':return 93;
		case 'Е':return 94;
		case 'е':return 95;
		case 'Ё':return 96;
		case 'ё':return 97;
		case 'Ж':return 98;
		case 'ж':return 99;
		case 'З':return 100;
		case 'з':return 101;
		case 'И':return 102;
		case 'и':return 103;
		case 'Й':return 104;
		case 'й':return 105;
		case 'К':return 106;
		case 'к':return 107;
		case 'Л':return 108;
		case 'л':return 109;
		case 'М':return 110;
		case 'м':return 111;
		case 'Н':return 112;
		case 'н':return 113;
		case 'О':return 114;
		case 'о':return 115;
		case 'П':return 116;
		case 'п':return 117;
		case 'Р':return 118;
		case 'р':return 119;
		case 'С':return 120;
		case 'с':return 121;
		case 'Т':return 122;
		case 'т':return 123;
		case 'У':return 124;
		case 'у':return 125;
		case 'Ф':return 126;
		case 'ф':return 127;
		case 'Х':return 128;
		case 'х':return 129;
		case 'Ц':return 130;
		case 'ц':return 131;
		case 'Ч':return 132;
		case 'ч':return 133;
		case 'Ш':return 134;
		case 'ш':return 135;
		case 'Щ':return 136;
		case 'щ':return 137;
		case 'Ъ':return 138;
		case 'ъ':return 139;
		case 'Ы':return 140;
		case 'ы':return 141;
		case 'Ь':return 142;
		case 'ь':return 143;
		case 'Э':return 144;
		case 'э':return 145;
		case 'Ю':return 146;
		case 'ю':return 147;
		case 'Я':return 148;
		case 'я':return 149;
		case '0':return 150;
		case '1':return 151;
		case '2':return 152;
		case '3':return 153;
		case '4':return 154;
		case '5':return 155;
		case '6':return 156;
		case '7':return 157;
		case '8':return 158;
		case '9':return 159;
		case 'È':return 160;
		case 'è':return 161;
		case 'É':return 162;
		case 'é':return 163;
		case 'Ê':return 164;
		case 'ê':return 165;
		case 'Ç':return 166;
		case 'ç':return 167;
		case 'À':return 168;
		case 'à':return 169;
		case 'Á':return 170;
		case 'á':return 171;
		case 'Â':return 172;
		case 'â':return 173;
		case 'Ä':return 174;
		case 'ä':return 175;
		case 'Ò':return 176;
		case 'ò':return 177;
		case 'Ó':return 178;
		case 'ó':return 179;
		case 'Ô':return 180;
		case 'ô':return 181;
		case 'Ö':return 182;
		case 'ö':return 183;
		case 'Ø':return 184;
		case 'ø':return 185;
		case 'Ù':return 186;
		case 'ù':return 187;
		case 'Ú':return 188;
		case 'ú':return 189;
		case 'Û':return 190;
		case 'û':return 191;
		case 'Ü':return 192;
		case 'ü':return 193;
		case 'Ć':return 194;
		case 'ć':return 195;
		case 'Ĉ':return 196;
		case 'ĉ':return 197;
			}
}
	
	private final static int[] r1 = new int[]{29,1,14,3,6,21,8,10,7,26,15,11,12,24,20,16,27,2,28,30,23,4,5,13,22,18,19,9,31,25,17,
			40,41,52,53,56,57,42,43,54,55,44,45,38,39,64,65,74,75,82,83,58,59,70,71,60,61,76,77,80,81,46,47,78,79,72,73,68,69,62,63,32,33,48,49,34,35,66,67,36,37,50,51,
			109,164,161,186,172,150,191,106,146,145,116,157,118,167,114,88,142,177,154,103,133,113,125,107,121,195,170,153,166,173,86,94,140,105,171,117,181,132,152,189,130,174,138,123,131,99,165,156,96,180,149,136,84,127,101,115,196,112,184,129,169,89,155,176,183,108,147,143,151,179,139,190,194,197,91,126,178,134,192,87,193,159,102,135,148,90,187,97,110,124,92,119,162,85,104,168,137,163,188,185,182,100,120,93,175,122,98,128,111,141,158,160,144,95,
			};
			private final static int[] r2 = new int[]{30,9,4,20,14,18,6,15,1,29,10,19,25,13,31,12,7,24,5,3,11,21,23,17,22,2,26,27,28,16,8,
			32,33,50,51,38,39,52,53,68,69,48,49,66,67,72,73,78,79,34,35,54,55,46,47,76,77,70,71,56,57,36,37,64,65,44,45,82,83,58,59,62,63,80,81,42,43,74,75,60,61,40,41,
			87,84,176,174,114,117,162,129,164,179,182,118,194,181,142,116,148,166,125,154,167,160,161,133,175,107,85,101,109,90,190,122,178,156,100,110,168,172,145,165,108,123,103,91,187,163,173,143,127,88,140,113,121,115,144,98,136,189,86,195,138,105,135,111,171,93,155,153,180,146,106,131,102,97,89,152,94,95,104,159,147,132,196,149,120,130,151,134,170,169,177,186,188,183,158,192,124,119,185,141,126,193,137,150,197,139,96,191,112,184,128,157,99,92,
			};
			private final static int[] r3 = new int[]{14,4,6,26,1,27,21,17,22,25,8,19,9,24,29,28,31,7,15,11,18,30,5,2,12,13,23,10,20,3,16,
			34,35,38,39,42,43,46,47,50,51,54,55,36,37,62,63,66,67,70,71,78,79,74,75,82,83,58,59,80,81,40,41,48,49,76,77,44,45,32,33,52,53,56,57,72,73,68,69,64,65,60,61,
			130,88,90,113,121,174,89,92,96,187,112,146,169,98,137,86,95,132,170,161,173,160,100,140,159,134,93,114,91,180,197,126,94,117,149,135,102,108,194,109,85,138,192,190,107,195,158,151,166,125,87,142,116,144,152,155,191,99,118,127,128,120,139,154,179,111,175,115,165,122,110,106,178,147,145,184,196,97,123,103,131,84,167,104,189,168,150,136,129,101,183,141,119,105,182,181,185,163,188,157,171,186,176,172,148,156,193,133,177,124,143,153,164,162,
			};
			private final static int[] r4 = new int[]{23,22,9,14,18,27,15,19,12,2,7,3,24,13,20,28,10,17,6,4,16,25,21,8,1,30,26,5,29,11,31,
			40,41,68,69,60,61,74,75,62,63,82,83,50,51,32,33,80,81,64,65,72,73,48,49,66,67,46,47,78,79,54,55,58,59,42,43,70,71,44,45,52,53,38,39,36,37,56,57,76,77,34,35,
			112,192,186,184,138,85,179,98,92,126,119,130,142,153,100,182,158,168,87,128,97,188,177,178,146,121,189,135,96,162,172,147,194,137,197,145,88,134,132,173,84,99,106,140,165,107,156,161,104,118,103,195,180,108,117,175,127,116,193,102,160,114,171,111,163,191,154,94,174,105,143,101,185,91,93,86,152,110,148,155,144,170,115,176,125,190,139,133,129,122,159,113,157,187,169,109,141,120,181,150,196,167,123,131,90,166,183,89,164,149,124,136,151,95,
			};
			private final static int[] r5 = new int[]{3,9,15,30,22,16,24,18,13,19,4,10,31,26,8,20,28,11,7,17,27,1,2,25,21,23,6,12,29,14,5,
			74,75,82,83,34,35,66,67,44,45,48,49,70,71,80,81,72,73,62,63,68,69,38,39,58,59,46,47,54,55,78,79,32,33,76,77,56,57,50,51,64,65,60,61,42,43,40,41,36,37,52,53,
			99,135,174,171,188,141,93,143,182,177,101,150,166,87,103,132,89,123,158,159,151,172,109,197,124,169,97,137,95,92,162,142,148,147,193,180,105,136,94,161,91,160,168,126,130,98,111,106,86,167,170,154,133,153,116,165,146,117,102,138,120,88,173,195,192,152,90,129,179,110,176,108,85,157,149,181,113,127,189,164,178,190,84,119,96,184,134,118,186,185,112,100,144,175,187,121,128,155,122,104,139,107,191,196,194,125,140,183,145,131,156,115,163,114,
			};
			private final static int[] r6 = new int[]{10,15,22,16,29,27,4,17,3,25,7,23,8,21,2,24,31,6,13,20,11,26,9,18,1,28,12,30,14,5,19,
			50,51,62,63,44,45,74,75,60,61,72,73,56,57,42,43,80,81,64,65,34,35,40,41,58,59,46,47,82,83,66,67,38,39,52,53,32,33,68,69,78,79,54,55,48,49,36,37,70,71,76,77,
			191,192,101,119,175,114,127,152,85,145,151,121,171,88,138,173,133,115,86,147,169,125,157,180,159,185,108,107,158,95,187,184,181,161,154,148,118,124,140,155,94,178,116,139,164,89,102,197,123,146,196,176,174,144,136,113,168,110,98,129,143,194,96,153,172,183,128,87,120,137,150,91,104,112,90,165,163,130,141,131,99,135,162,177,149,132,193,170,126,160,122,188,195,84,117,182,186,179,92,166,156,167,111,103,106,142,93,134,109,97,190,189,100,105,
			};
			private final static int[] r7 = new int[]{14,26,13,11,31,7,24,22,21,3,8,23,27,9,17,28,5,25,20,2,29,30,10,16,18,12,19,4,1,15,6,
			58,59,82,83,50,51,46,47,44,45,66,67,36,37,78,79,56,57,80,81,68,69,76,77,34,35,60,61,72,73,42,43,32,33,48,49,74,75,54,55,62,63,40,41,52,53,64,65,38,39,70,71,
			142,103,149,162,99,191,148,163,185,195,153,155,122,109,176,150,119,172,106,189,102,120,132,131,179,154,87,84,139,186,123,188,101,133,94,192,160,167,169,182,143,194,144,190,86,166,165,116,118,91,178,126,168,156,164,177,175,111,110,105,152,141,88,183,180,121,138,174,157,145,107,187,100,125,136,95,108,124,93,113,96,130,193,89,114,135,137,158,196,112,146,171,129,147,181,128,117,151,161,173,170,98,97,92,134,85,90,184,115,104,127,159,140,197,
			};
			private final static int[] r8 = new int[]{24,26,30,2,22,11,3,5,25,28,31,15,20,13,4,6,21,1,12,14,7,17,8,29,23,18,27,19,16,9,10,
			42,43,52,53,64,65,46,47,70,71,54,55,78,79,60,61,36,37,34,35,50,51,68,69,62,63,38,39,82,83,66,67,32,33,56,57,40,41,76,77,58,59,48,49,72,73,80,81,44,45,74,75,
			96,156,123,94,120,162,91,112,87,89,165,171,93,151,174,135,155,136,133,127,186,134,126,181,99,189,132,141,142,118,175,117,119,163,154,177,196,86,101,179,139,115,85,92,114,149,148,153,116,167,105,138,150,128,173,144,109,113,88,103,176,166,98,90,180,137,146,107,130,187,143,172,131,140,192,152,84,147,122,104,191,183,184,125,168,121,145,164,160,182,195,197,161,97,193,185,100,159,129,190,106,194,169,108,95,157,110,111,170,124,158,102,188,178,
			};
			private final static int[] r9 = new int[]{21,12,4,15,27,11,28,6,7,17,16,2,23,25,24,5,8,13,18,30,3,29,31,22,10,19,20,14,9,1,26,
			54,55,40,41,80,81,50,51,74,75,36,37,58,59,48,49,78,79,76,77,62,63,34,35,64,65,56,57,38,39,66,67,70,71,32,33,52,53,82,83,44,45,42,43,72,73,46,47,60,61,68,69,
			167,174,130,109,114,122,136,124,149,188,93,144,134,123,117,179,108,97,118,112,110,196,171,159,106,105,181,189,156,115,87,147,99,163,151,129,154,101,133,197,111,194,183,177,145,113,138,166,146,165,172,100,102,185,127,84,116,182,187,126,168,192,98,103,120,162,121,119,178,86,141,186,125,89,153,150,88,160,139,137,158,131,152,195,143,175,173,191,169,157,170,90,107,92,184,180,140,148,85,95,96,155,164,91,142,176,135,190,104,94,193,128,161,132,
			};
			private final static int[] r10 = new int[]{22,31,16,6,8,20,28,2,11,21,9,14,25,26,17,7,1,19,24,13,23,10,29,18,27,3,15,4,30,5,12,
			42,43,68,69,60,61,52,53,32,33,58,59,72,73,40,41,66,67,46,47,56,57,34,35,70,71,48,49,80,81,36,37,76,77,54,55,64,65,62,63,82,83,78,79,74,75,44,45,50,51,38,39,
			164,94,130,182,90,118,89,129,86,188,119,124,139,112,103,145,157,142,179,85,136,152,148,166,194,122,131,186,195,146,134,138,184,117,109,110,187,121,177,180,171,87,126,181,156,159,95,140,153,92,116,113,154,193,160,135,183,172,162,192,176,174,150,144,104,190,96,165,128,97,123,137,141,161,197,114,127,111,125,105,163,106,168,167,120,115,100,99,155,151,196,149,108,101,88,132,170,98,107,173,178,191,147,169,84,102,133,143,189,185,158,93,175,91,
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
		while (local >= 198){
			local -=197;
		}
		return r1[local-1];
	}
	
	private static final int ungetr1(int id,int rotor){
		int local =search(r1, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr2(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r2[local-1];
	}
	
	private static final int ungetr2(int id,int rotor){
		int local =search(r2, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr3(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r3[local-1];
	}
	
	private static final int ungetr3(int id,int rotor){
		int local =search(r3, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr4(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r4[local-1];
	}
	
	private static final int ungetr4(int id,int rotor){
		int local =search(r4, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr5(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r5[local-1];
	}
	
	private static final int ungetr5(int id,int rotor){
		int local =search(r5, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr6(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r6[local-1];
	}
	
	private static final int ungetr6(int id,int rotor){
		int local =search(r6, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr7(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r7[local-1];
	}
	
	private static final int ungetr7(int id,int rotor){
		int local =search(r7, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr8(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r8[local-1];
	}
	
	private static final int ungetr8(int id,int rotor){
		int local =search(r8, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr9(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r9[local-1];
	}
	
	private static final int ungetr9(int id,int rotor){
		int local =search(r9, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
		}
		return local;
	}
	
	private static final int getr10(int id,int rotor){
		int local = abs(id + rotor);
		while (local >= 198){
			local -=197;
		}
		return r10[local-1];
	}
	
	private static final int ungetr10(int id,int rotor){
		int local =search(r10, id);
		local++;
		local -= rotor;
		while (local <= 0){
			local += 197;
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

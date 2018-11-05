public class Entry <s,k1 extends Comparable <k1>,k2 extends Comparable <k2>> implements Comparable<Entry <s,k1,k2>> {
//Attributes
		public s  value;
		public k1 key1;
		public k2 key2;
		public Entry() {
			value = null;
			key1  = null;
			key2  = null;
		}
		public Entry(s value, k1 key1, k2 key2) {
			this.value = value;
			this.key1  = key1;
			this.key2  = key2;
		}

//Getters and Setters
		public s getValue() {
			return value;
		}
		public void setValue(s value) {
			this.value = value;
		}
		public k1 getKey1() {
			return key1;
		}
		public void setKey1(k1 key1) {
			this.key1 = key1;
		}
		public k2 getKey2() {
			return key2;
		}
		public void setKey2(k2 key2) {
			this.key2 = key2;
		}
		public int compareTo(Entry <s,k1,k2> o) {
			return this.key1.compareTo(o.key1); 
		}
		
		public static void main(String[]args) {
			Entry e1 = new Entry <String,Integer,Integer>();
			e1.key1=1;
			e1.key2=2;
			e1.value="poato";
			Entry e2 = new Entry <String,Integer,Integer>();
			e2.key1=2;
			e2.key2=2;
			e2.value="poato";
			System.out.println(e1.compareTo(e2));
		}
		
	}

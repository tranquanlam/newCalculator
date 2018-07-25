package com.trungtam.model;

public class UserDTO {
		int id;
		String ten;
		String tuoi;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTen() {
			return ten;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public String getTuoi() {
			return tuoi;
		}
		public void setTuoi(String tuoi) {
			this.tuoi = tuoi;
		}
		public UserDTO() {
			super();
		}
		public UserDTO(int id, String ten, String tuoi) {
			super();
			this.id = id;
			this.ten = ten;
			this.tuoi = tuoi;
		}
		@Override
		public String toString() {
			return "hello2 [id=" + id + ", ten=" + ten + ", tuoi=" + tuoi + "]";
		}
		
}

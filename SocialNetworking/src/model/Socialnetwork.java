package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SOCIALNETWORK database table.
 * 
 */
@Entity
@Table(name="SOCIALNETWORK", schema = "TESTUSER")
@NamedQuery(name="Socialnetwork.findAll", query="SELECT s FROM Socialnetwork s")
public class Socialnetwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long userid;

	@Column(name="ADDRESS_LINE_1", nullable=false, length=255)
	private String addressLine1;

	@Column(name="ADDRESS_LINE_2", nullable=false, length=255)
	private String addressLine2;

	@Column(nullable=false, length=255)
	private String city;

	@Column(nullable=false, length=255)
	private String emailid;

	@Column(length=255)
	private String favoritecolor;

	@Column(length=255)
	private String favoritemovie;

	@Column(length=255)
	private String favoritesong;

	@Column(nullable=false, length=255)
	private String firstname;

	@Column(nullable=false, length=255)
	private String lastname;

	@Column(nullable=false, length=255)
	private String nickname;

	@Column(nullable=false, length=255)
	private String password;

	@Column(nullable=false)
	private BigDecimal postalcode;

	@Column(name="\"STATE\"", nullable=false, length=255)
	private String state;

	public Socialnetwork() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFavoritecolor() {
		return this.favoritecolor;
	}

	public void setFavoritecolor(String favoritecolor) {
		this.favoritecolor = favoritecolor;
	}

	public String getFavoritemovie() {
		return this.favoritemovie;
	}

	public void setFavoritemovie(String favoritemovie) {
		this.favoritemovie = favoritemovie;
	}

	public String getFavoritesong() {
		return this.favoritesong;
	}

	public void setFavoritesong(String favoritesong) {
		this.favoritesong = favoritesong;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(BigDecimal postalcode) {
		this.postalcode = postalcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
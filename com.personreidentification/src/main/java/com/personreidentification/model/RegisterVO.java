package com.personreidentification.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="register_table")
public class RegisterVO {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//@Column(name="premises_name")
	//private String premisesName;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="password")
	private String password;
	
	//@Column(name="premises_contact_number")
	//private String premisesContactNumber;
	
	@Column(name="premises_address")
	private String premisesAddress;
	
		@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="country_id")
	private CountryVO countryVO;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="state_id")
	private StateVO stateVO;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="city_id")
	private CityVO cityVO;	
	
	@Column(name="owner_name")
	private String ownerName;
	
	@Column(name="owner_contact_number")
	private String ownerContactNumber;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="login_id")
	private LoginVO loginVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public String getPremisesName() {
		return premisesName;
	}

	public void setPremisesName(String premisesName) {
		this.premisesName = premisesName;
	}
*/
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getPremisesContactNumber() {
		return premisesContactNumber;
	}

	public void setPremisesContactNumber(String premisesContactNumber) {
		this.premisesContactNumber = premisesContactNumber;
	}*/

	public String getPremisesAddress() {
		return premisesAddress;
	}

	public void setPremisesAddress(String premisesAddress) {
		this.premisesAddress = premisesAddress;
	}

	public CountryVO getCountryVO() {
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}	
	
}

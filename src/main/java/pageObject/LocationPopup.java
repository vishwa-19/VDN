package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocationPopup {
	
	@FindBy(how=How.XPATH,using="//ngx-avatar[@title='Welcome Guest, Click here to continue to your profile']")
	private WebElement Guesticon;
	
	@FindBy(how=How.XPATH,using="//input[@id='name']")
	private WebElement guestNameTextField;

	@FindBy(how=How.XPATH,using="(//div[@role='list'])[3]")
	private WebElement Role;
	
	@FindBy(how=How.XPATH,using="//*[@id='state']/div[1]")
	private WebElement State;
	
	@FindBy(how=How.XPATH,using="//*[@id='state']//span[text()='Maharashtra']")
	private WebElement MaharashtraState;
	
	@FindBy(how=How.XPATH,using="//span[text()='Andhra Pradesh']")
	private WebElement AndhraPradesh;
	
	@FindBy(how=How.XPATH,using="//*[@id='district']/div[1]")
	private WebElement District;
	
	@FindBy(how=How.XPATH,using="//span[text()='Akola']")
	private WebElement AkolaDistrict;
	
	@FindBy(how=How.XPATH,using="(//button[@type='submit'])[2]")
	private WebElement SubmitButton;
	//ngx-avatar[@title='Welcome Guest, Click here to continue to your profile']
	
	@FindBy(how=How.XPATH,using="(//button[text()='Edit'])[1]")
	private WebElement locationeditbutton;
	
	@FindBy(how=How.XPATH,using="(//div[@role='list'])[1]")
	private WebElement guestRole;
	
	@FindBy(how=How.XPATH,using="//span[text()='Teacher']")
	private WebElement teacher;
	
	@FindBy(how=How.XPATH,using="//span[text()='Student']")
	private WebElement student;
	
	@FindBy(how=How.XPATH,using="//span[text()='Amravati']")
	private WebElement Amravati;
	
	@FindBy(how=How.XPATH,using="(//button[@type='submit'])[2]")
	private WebElement LocationSubmitButton;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Amravati ']")
	private WebElement TextAmravati;
	
	@FindBy(how=How.XPATH,using=" //div[text()=' Teacher']")
	private WebElement Teacherprofile;
	
	@FindBy(how=How.XPATH,using="//span[text()='Head teacher & Official']")
	private WebElement HTOfficial;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label=', selected ,Select Subrole']")
	private WebElement SubRole;
	
	@FindBy(how=How.XPATH,using="//span[text()='Principal']")
	private WebElement principle;
	
	@FindBy(how=How.XPATH,using="//button[text()='Submit ']")
	private WebElement PersonalDetailSubmitButton;
	
	@FindBy(how=How.XPATH,using=" //div[text()='Parent']")
	private WebElement TextParent;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Alluri Sita Rama Raju ']")
	private WebElement TextDistrict;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Andhra Pradesh']")
	private WebElement TextAP;
	
	@FindBy(how=How.XPATH,using="//span[text()='Parent']")
	private WebElement parent;
	
	@FindBy(how=How.XPATH,using="//span[text()='Alluri Sita Rama Raju']")
	private WebElement DistrictAlluriSitaRamaRaju;
	
	@FindBy(how=How.XPATH,using="//span[text()='Headmaster']")
	private WebElement Headmaster;
	

	public WebElement getHeadmaster() {
		return Headmaster;
	}
	
	
	@FindBy(how=How.XPATH,using="//span[text()='State level - OICs']")
	private WebElement StateLevelOIC;

	public WebElement getStateLevelOIC() {
		return StateLevelOIC;
	}

	public void setStateLevelOIC(WebElement stateLevelOIC) {
		StateLevelOIC = stateLevelOIC;
	}

	public void setGuesticon(WebElement guesticon) {
		Guesticon = guesticon;
	}

	public void setGuestNameTextField(WebElement guestNameTextField) {
		this.guestNameTextField = guestNameTextField;
	}

	public void setRole(WebElement role) {
		Role = role;
	}

	public void setState(WebElement state) {
		State = state;
	}

	public void setMaharashtraState(WebElement maharashtraState) {
		MaharashtraState = maharashtraState;
	}

	public void setAndhraPradesh(WebElement andhraPradesh) {
		AndhraPradesh = andhraPradesh;
	}

	public void setDistrict(WebElement district) {
		District = district;
	}

	public void setAkolaDistrict(WebElement akolaDistrict) {
		AkolaDistrict = akolaDistrict;
	}

	public void setSubmitButton(WebElement submitButton) {
		SubmitButton = submitButton;
	}

	public void setGuestRole(WebElement guestRole) {
		this.guestRole = guestRole;
	}

	public void setStudent(WebElement student) {
		this.student = student;
	}

	public void setHTOfficial(WebElement hTOfficial) {
		HTOfficial = hTOfficial;
	}

	public void setSubRole(WebElement subRole) {
		SubRole = subRole;
	}

	public void setPrinciple(WebElement principle) {
		this.principle = principle;
	}

	public void setPersonalDetailSubmitButton(WebElement personalDetailSubmitButton) {
		PersonalDetailSubmitButton = personalDetailSubmitButton;
	}

	public void setParent(WebElement parent) {
		this.parent = parent;
	}

	public void setDistrictAlluriSitaRamaRaju(WebElement districtAlluriSitaRamaRaju) {
		DistrictAlluriSitaRamaRaju = districtAlluriSitaRamaRaju;
	}

	public void setHeadmaster(WebElement headmaster) {
		Headmaster = headmaster;
	}

	
	public WebElement getDistrictAlluriSitaRamaRaju() {
		return DistrictAlluriSitaRamaRaju;
	}
	
	public WebElement getStudent() {
		return student;
	}

	
	public WebElement getAndhraPradesh() {
		return AndhraPradesh;
	}
	
	public WebElement getparent() {
		return parent;
	}
	
	public WebElement getTextParent() {
		return TextParent;
	}

	public void setTextParent(WebElement textParent) {
		TextParent = textParent;
	}

	public WebElement getTextDistrict() {
		return TextDistrict;
	}

	public void setTextDistrict(WebElement textDistrict) {
		TextDistrict = textDistrict;
	}

	public WebElement getTextAP() {
		return TextAP;
	}

	public void setTextAP(WebElement textAP) {
		TextAP = textAP;
	}

	public WebElement getPersonalDetailSubmitButton() {
		return PersonalDetailSubmitButton;
	}
	
	public WebElement getSubRole() {
		return SubRole;
	}


	public WebElement getPrinciple() {
		return principle;
	}

	
	public WebElement getHTOfficial() {
		return HTOfficial;
	}
	
	public WebElement getguestRole() {
		return guestRole;
	}
	
	public WebElement getLocationeditbutton() {
		return locationeditbutton;
	}



	public void setLocationeditbutton(WebElement locationeditbutton) {
		this.locationeditbutton = locationeditbutton;
	}



	public WebElement getTeacher() {
		return teacher;
	}



	public void setTeacher(WebElement teacher) {
		this.teacher = teacher;
	}



	public WebElement getAmravati() {
		return Amravati;
	}



	public void setAmravati(WebElement amravati) {
		Amravati = amravati;
	}



	public WebElement getLocationSubmitButton() {
		return LocationSubmitButton;
	}



	public void setLocationSubmitButton(WebElement locationSubmitButton) {
		LocationSubmitButton = locationSubmitButton;
	}



	public WebElement getTextAmravati() {
		return TextAmravati;
	}



	public void setTextAmravati(WebElement textAmravati) {
		TextAmravati = textAmravati;
	}



	public WebElement getTeacherprofile() {
		return Teacherprofile;
	}



	public void setTeacherprofile(WebElement teacherprofile) {
		Teacherprofile = teacherprofile;
	}
	
	
	
	
	
	public WebElement getGuestNameTextField() {
		return guestNameTextField;
	}



	public WebElement getGuesticon() {
		return Guesticon;
	}
	
	
	public WebElement getRole() {
		return Role;
	}
	
	
	public WebElement getState() {
		return State;
	}

	public WebElement getMaharashtraState() {
		return MaharashtraState;
	}

	public WebElement getDistrict() {
		return District;
	}

	public WebElement getAkolaDistrict() {
		return AkolaDistrict;
	}
	
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
}

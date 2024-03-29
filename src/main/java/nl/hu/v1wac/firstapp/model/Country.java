package nl.hu.v1wac.firstapp.model;

public class Country {
	private String code;
	private String iso3;
	private String name;
	private String continent;
	private String region;
	private double surface;
	private int indepyear;
	private int population;
	private int lifeexpectancy;
	private int gnp;
	private int gnpoid;
	private String localname;
	private String government;
	private String headofstate;
	private double latitude;
	private double longitude;
	private String capital;
	
	//Constructor voor de functie gegevens wijzigen
	public Country(String code, String iso3, String nm, String cap, String ct, String reg, double sur, int pop, String gov, double lat, double lng) {
		this.code = code; 
		this.iso3 = iso3;
		this.name = nm;
		this.capital = cap;
		this.continent = ct;
		this.region = reg;
		this.surface = sur;
		this.population = pop;
		this.government = gov;
		this.latitude = lat;
		this.longitude = lng;
	}
	
	//Constructor voor de functie land aanmaken
	public Country(String code, String iso3, String name, String continent, String region, 
					double surface, int indepyear, int population, int lifeexpectancy, 
					int gnp, int gnpoid, String localname, String governmentform,
					String headofstate, double latitude, double longitude, String capital) {
		this.code = code; 
		this.iso3 = iso3;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface = surface;
		this.indepyear = indepyear;
		this.population = population;
		this.lifeexpectancy = lifeexpectancy;
		this.gnp = gnp;
		this.gnpoid = gnpoid;
		this.localname = localname;
		this.government = governmentform;
		this.headofstate = headofstate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.capital = capital;
	}
	
	public int getIndepyear() {
		return indepyear;
	}

	public void setIndepyear(int indepyear) {
		this.indepyear = indepyear;
	}

	public int getLifeexpectancy() {
		return lifeexpectancy;
	}

	public void setLifeexpectancy(int lifeexpectancy) {
		this.lifeexpectancy = lifeexpectancy;
	}

	public int getGnp() {
		return gnp;
	}

	public void setGnp(int gnp) {
		this.gnp = gnp;
	}

	public int getGnpoid() {
		return gnpoid;
	}

	public void setGnpoid(int gnpoid) {
		this.gnpoid = gnpoid;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getHeadofstate() {
		return headofstate;
	}

	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}

	public String getCode() {
		return code;
	}
	
	public String getIso3() {
		return iso3;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public String getRegion() {
		return region;
	}
	
	public double getSurface() {
		return surface;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getGovernment() {
		return government;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}

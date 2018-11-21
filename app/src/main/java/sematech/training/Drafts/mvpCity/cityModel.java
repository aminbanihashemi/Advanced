package sematech.training.Drafts.mvpCity;

public class cityModel {
    String name , country , language , currency ;
    String imgFlag,imgCity;
    long population;

    @Override
    public String toString() {
        return "cityModel{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", currency='" + currency + '\'' +
                ", imgFlag='" + imgFlag + '\'' +
                ", imgCity='" + imgCity + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(String imgFlag) {
        this.imgFlag = imgFlag;
    }

    public String getImgCity() {
        return imgCity;
    }

    public void setImgCity(String imgCity) {
        this.imgCity = imgCity;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}

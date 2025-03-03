package org.example.countryflaggame;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HelloController {
    @FXML
    ImageView flagImageView;
    @FXML Label scoreKeeperLabel;
    @FXML Button optionOneButton;
    @FXML
    Button optionTwoButton;
    @FXML Button optionThreeButton;
    @FXML Button optionFourButton;
    @FXML Label informationLabel;


    ArrayList<String> countryFlagNames = new ArrayList<>(Arrays.asList("Afghanistan,af","Albania,al", "Algeria,dz", "Andorra,ad", "Angola,ao", "Antigua and Barbuda,ag", "Argentina,ar", "Armenia,am", "Australia,au", "Austria,at", "Azerbaijan,az", "Bahamas,bs", "Bahrain,bh", "Bangladesh,bd", "Barbados,bb", "Belarus,by", "Belgium,be", "Belize,bz", "Benin,bj", "Bhutan,bt", "Bolivia,bo", "Bosnia and Herzegovina,ba", "Botswana,bw", "Brazil,br", "Brunei Darussalam,bn", "Bulgaria,bg", "Burkina Faso,bf", "Burundi,bi", "Cabo Verde,cv", "Cambodia,kh", "Cameroon,cm", "Canada,ca", "Central African Republic,cf", "Chad,td", "Chile,cl", "China,cn", "Colombia,co", "Comoros,km", "Congo,cg", "Congo,cd", "Costa Rica,cr", "Cote d'Ivoire,ci", "Croatia,hr", "Cuba,cu", "Cyprus,cy", "Czechia,cz", "Denmark,dk", "Djibouti,dj", "Dominica,dm", "Dominican Republic,do", "Ecuador,ec", "Egypt,eg", "El Salvador,sv", "Equatorial Guinea,gq", "Eritrea,er", "Estonia,ee", "Eswatini,sz", "Ethiopia,et", "Fiji,fj", "Finland,fi", "France,fr", "Gabon,ga", "Gambia,gm", "Georgia,ge", "Germany,de", "Ghana,gh", "Greece,gr", "Grenada,gd", "Guatemala,gt", "Guinea,gn", "Guinea-Bissau,gw", "Guyana,gy", "Haiti,ht", "Honduras,hn", "Hungary,hu", "Iceland,is", "India,in", "Indonesia,id", "Iran,ir", "Iraq,iq", "Ireland,ie", "Israel,il", "Italy,it", "Jamaica,jm", "Japan,jp", "Jordan,jo", "Kazakhstan,kz", "Kenya,ke", "Kiribati,ki", "North Korea,kp", "South Korea,kr", "Kuwait,kw", "Kyrgyzstan,kg", "Laos,la", "Latvia,lv", "Lebanon,lb", "Lesotho,ls", "Liberia,lr", "Libya,ly", "Liechtenstein,li", "Lithuania,lt", "Luxembourg,lu", "Madagascar,mg", "Malawi,mw", "Malaysia,my", "Maldives,mv", "Mali,ml", "Malta,mt", "Marshall Islands,mh", "Mauritania,mr", "Mauritius,mu", "Mexico,mx", "Micronesia,fm", "Moldova,md", "Monaco,mc", "Mongolia,mn", "Montenegro,me", "Morocco,ma", "Mozambique,mz", "Myanmar,mm", "Namibia,na", "Nauru,nr", "Nepal,np", "Netherlands,nl", "New Zealand,nz", "Nicaragua,ni", "Niger,ne", "Nigeria,ng", "North Macedonia,mk", "Norway,no", "Oman,om", "Pakistan,pk", "Palau,pw", "Panama,pa", "Papua New Guinea,pg", "Paraguay,py", "Peru,pe", "Philippines,ph", "Poland,pl", "Portugal,pt", "Qatar,qa", "Romania,ro", "Russian Federation,ru", "Rwanda,rw", "Saint Kitts and Nevis,kn", "Saint Lucia,lc", "Saint Vincent and the Grenadines,vc", "Samoa,ws", "San Marino,sm", "Sao Tome and Principe,st", "Saudi Arabia,sa", "Senegal,sn", "Serbia,rs", "Seychelles,sc", "Sierra Leone,sl", "Singapore,sg", "Slovakia,sk", "Slovenia,si", "Solomon Islands,sb", "Somalia,so", "South Africa,za", "South Sudan,ss", "Spain,es", "Sri Lanka,lk", "Sudan,sd", "Suriname,sr", "Sweden,se", "Switzerland,ch", "Syrian Arab Republic,sy", "Tajikistan,tj", "Tanzania,tz", "Thailand,th", "Timor-Leste,tl", "Togo,tg", "Tonga,to", "Trinidad and Tobago,tt", "Tunisia,tn", "Turkey,tr", "Turkmenistan,tm", "Tuvalu,tv", "Uganda,ug", "Ukraine,ua", "United Arab Emirates,ae", "Great Britain,gb", "United States of America,us", "Uruguay,uy", "Uzbekistan,uz", "Vanuatu,vu", "Venezuela,ve", "Vietnam,vn", "Yemen,ye", "Zambia,zm", "Zimbabwe,zw"));

    ArrayList <String> guesses = new ArrayList<>();
    String imageName;
    String correctCountry;
    Image flagImage;
    Integer score;

    public void initialize() {
        score = 0;
        gameSetup();

    }

    public void buttonHandler(Event event){
        Button pressedButton = (Button)event.getSource();
        if(correctCountry.equals(pressedButton.getText())){
            informationLabel.setText("Correct!");
            score++;
        }

        else{
            informationLabel.setText("Wrong Answer! \nIt should be: " + correctCountry);
        }
        scoreKeeperLabel.setText("Score: " + score + "/22");

        gameSetup();
    }

    private void gameSetup() {
        if(countryFlagNames.size() < 3){
            System.exit(0);
        }
        guesses.clear();
        Collections.shuffle(countryFlagNames);
        correctCountry = countryFlagNames.get(0);
        guesses.add(correctCountry);
        countryFlagNames.remove(correctCountry);

        scoreKeeperLabel.setText("Score: " + score);
        for(int i = 1; i< 4; i ++){
            guesses.add(countryFlagNames.get(i));
        }
        Collections.shuffle(guesses);
        optionOneButton.setText(guesses.get(0));
        optionTwoButton.setText(guesses.get(1));
        optionThreeButton.setText(guesses.get(2));
        optionFourButton.setText(guesses.get(3));

        imageName = correctCountry.toLowerCase().split(",")[correctCountry.split(",").length - 1];
        imageName = imageName.concat(".png");
        String imagePath = "/images/".concat(imageName);
        flagImage = new Image(getClass().getResourceAsStream(imagePath));
        flagImageView.setImage(flagImage);

    }

}
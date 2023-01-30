package Store;

public class Formater {
    public String alignProducts(String string){
        int spaceInt = 20-string.length();
        String spaceString = "";

        for(int i = 0; i < spaceInt; i++){
            spaceString += " ";
        }
        return spaceString;
    }


}

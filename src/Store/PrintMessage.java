package Store;

public class PrintMessage {
// Använder vid tid
    public void welcomeMenu(boolean loggedIn){
        String accountChoice = null;

        if (!(loggedIn)) {
            accountChoice = "Login";
        } else if (loggedIn) {
            accountChoice = "Logout";
        }

        System.out.println("Welcome to the shoeShop!");
        System.out.println("Please chose action from menu");
        System.out.println("0: Exit");
        System.out.println("1: "+ accountChoice);
        if (loggedIn) System.out.println("2: Show shop");

    }


}

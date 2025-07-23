public class HealthRecord {

    /*****************************************************
    ************************ Setup ***********************
    ******************************************************/

    // Instance field
    private int height;  // student's height in centimeters

    // Constants (static final)
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // TODO: Initialize appropriately
    // Class-level tracking (static)
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;
    private static int counter = 0;      // count number of objects
    private static double averageHeight; // track average height

    /*****************************************************
     ******************** Constructor *********************
     ******************************************************/

    public HealthRecord(int height) {
        setHeight(height);
    }

    /*****************************************************
     *********************** Getter ***********************
     ******************************************************/

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static double getAverageHeight() {
        return averageHeight;
    }

    /*****************************************************
     *********************** Setter ***********************
     ******************************************************/

    public void setHeight(int height) {

        // TODO: Validate height is within permitted range
        if (height < MAX_PERMITTED_HEIGHT  && height > MIN_PERMITTED_HEIGHT) {
            this.height = height;
        }
        else {
            this.height = DEFAULT_HEIGHT;
        }

        // TODO: Update tallest and shortest heights
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        // Update average using: y' = (y*n + x)/(n+1)
        averageHeight = (averageHeight*counter + this.height)/(++counter);

    }

    /*****************************************************
     *********************** Display ***********************
     ******************************************************/

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
    }
}
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        // currentDisplay.display();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        // statisticsDisplay.display();
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        // Simulating new weather measurements
        weatherData.setMeasurements(26.6f, 65.0f, 1013.1f);
        // weatherData.setMeasurements(28.0f, 70.0f, 1012.5f);
        // weatherData.setMeasurements(22.5f, 55.0f, 1015.2f);
    }
}

public class Request
{
	/**
		Airline class to hold the airline information.
	**/
	public static class Airline
	{
		public String name; // Name of the airline.
		public String number; // Flight number.
		public String source; // Flight source.
		public String destination; // Flight destination.

		/**
			Constructor: creates an Airline object with appropriate information.
		**/
		public Airline(String name, String number, String source, String destination)
		{
			this.name = name;
			this.number = number;
			this.source = source;
			this.destination = destination;
		}

		/**
			toString method to print the string representation of an airline.
		**/
		public String toString()
		{
			return name + " " + number + " " + source + " " + destination;
		}
	}

	public char command;  // Command, either r (request) or t (advance time).
	public int time;        // The time at which the airline requests use of runway.
	public Airline airline; // Airline object storing the meta data of the airline.

	/**
		Constructor: creates a Request object that represents the t command. No need for airline information.
	**/
	public Request(char command, int time)
	{
		this.command = command;
		this.time = time;
		this.airline = null;
	}

	/**
		Constructor: creates a Request object that represents the r command. Stores the airline information for this request.
	**/
	public Request(char command, int time, String name, String number, String source, String destination)
	{
		this(command, time);
		this.airline = new Airline(name, number, source, destination);
	}

	/**
		toString method to print the string representation of a request.
	**/
	public String toString()
	{
		return command + " " + time + " " + airline;
	}	
}

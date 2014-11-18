package commands

import org.crsh.cli.Command;
import org.crsh.cli.Usage;
import org.crsh.cli.Option;

class date {
  @Usage("show the current time")
  @Command
  Object main(
     @Usage("the time format")
     @Option(names=["f","format"])
     String format,
     @Option(names=["e","epoch"])
     Boolean epoch) {
    if (epoch) {
        return System.currentTimeMillis();
    }
    if (format == null)
      format = "EEE MMM d HH:mm:ss z yyyy";
    def date = new Date();
    return date.format(format);
  }
}
package nl.minetopiasdb.cookiebot.commands.stocks;

import java.text.DecimalFormat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import nl.minetopiasdb.cookiebot.data.stocks.StockData;
import nl.minetopiasdb.cookiebot.data.stocks.StockValue;
import nl.minetopiasdb.cookiebot.utils.BotConfig;
import nl.minetopiasdb.cookiebot.utils.MessageHandler;
import nl.minetopiasdb.cookiebot.utils.commands.BotCommand;
import nl.minetopiasdb.cookiebot.utils.commands.Command;

public class StockCMD implements BotCommand {

	@Override
	public void execute(Command cmd, String[] args, Message msg) {
		EmbedBuilder builder = MessageHandler.getHandler().getDefaultEmbed("Aandelen");

		String desc = "";
		for (String symbol : BotConfig.getInstance().stocks.keySet()) {
			String name = BotConfig.getInstance().stocks.get(symbol);

			StockValue value = StockData.getInstance().getValue(symbol);
			double valueChange = (value.getCurrentPrice() - value.getOpenPrice()) / ((double) value.getOpenPrice())
					* 100;
			DecimalFormat df = new DecimalFormat("0.00");
			String valueChangeStr = valueChange > 0 ? "+" + df.format(valueChange) : "" + df.format(valueChange);

			desc = desc + "\n**" + name + "** (" + symbol + "): " + value.getCurrentPrice() + " koekjes ("
					+ valueChangeStr + "%)";
		}
		builder.setDescription(desc);
		msg.getChannel().sendMessage(builder.build()).queue();
	}

}

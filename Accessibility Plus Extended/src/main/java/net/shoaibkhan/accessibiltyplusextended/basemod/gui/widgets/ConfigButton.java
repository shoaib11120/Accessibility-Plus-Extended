package net.shoaibkhan.accessibiltyplusextended.basemod.gui.widgets;

import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.minecraft.text.TranslatableText;
import net.shoaibkhan.accessibiltyplusextended.basemod.NarratorPlus;
import net.shoaibkhan.accessibiltyplusextended.basemod.config.Config;

public class ConfigButton extends WButton {
  private String translateKey;
  private String jsonKey;

  public ConfigButton(String translationKey, String jsonKey) {
    super(new TranslatableText(translationKey, Config.get(jsonKey) ? "on" : "off"));
    this.translateKey = translationKey;
    this.jsonKey = jsonKey;

  }

  @Override
  public InputResult onClick(int x, int y, int button) {
    super.onClick(x, y, button);
    boolean enabled = Config.toggle(this.jsonKey);
    TranslatableText newButtonText = new TranslatableText(this.translateKey, enabled ? "on" : "off");
    this.setLabel(newButtonText);
    NarratorPlus.narrate(this.getLabel().getString());
    // Toggle the value
    // Save hte value
    return InputResult.PROCESSED;
  }
}

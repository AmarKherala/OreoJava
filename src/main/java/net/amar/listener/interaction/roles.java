package net.amar.listener.interaction;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class roles extends ListenerAdapter {
static String r1 ="1307766379234988153";
static String r2 ="";
static String r3 ="";
static String r4 ="";
static String r5 ="";
static String r6 ="";
static String r7 ="";
static String r8 ="";
static String r9 ="";

  @Override
  public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
    Guild g = event.getGuild();
    Member member = event.getMember();
    // remove all color roles before procceding
    List<String> roles = List.of(
        "",
        "1308846283766894624",
        "1309075735272488960",
        "1306218380306681916",
        "1405197124806643782",
        "1307016237326401569",
        "1305880394335522887",
        "1401951980611702925",
        "1307366663133597726");
    String roleId = event.getValues().get(0);
    Role role = g.getRoleById(roleId);
    List<Role> memberRoles = new ArrayList<>(member.getRoles());
    memberRoles.removeIf(r -> roles.contains(r.getId()));
    memberRoles.add(role);
    event.deferReply(true).queue(hook -> g.modifyMemberRoles(member, memberRoles).queue(
        success -> event.getHook().sendMessage("Color added successfully!").setEphemeral(true),
        failure -> event.getHook().sendMessage("Failed to add color.").setEphemeral(true)));

    // remove all colors
    if (roleId.equals("0")) {
      event.deferReply(true)
          .queue(hook -> g.modifyMemberRoles(member, memberRoles).queue(
              success -> event.getHook().sendMessage("All colors removed!").setEphemeral(true),
              failure -> event.getHook().sendMessage("Something went wrong...").setEphemeral(true)));

    }
  }
}

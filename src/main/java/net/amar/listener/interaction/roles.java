package net.amar.listener.interaction;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.amar.jsonload;
import net.amar.log;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class roles extends ListenerAdapter {

  private final jsonload load = new jsonload();

  @Override
  public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
    load.readFile();
    Guild g = event.getGuild();
    Member member = event.getMember();
    // roles you want you clear from the user each interaction
    List<String> roles = List.of(
        load.black,
        load.green,
        load.lightblue,
        load.purple,
        load.yellow,
        load.orange,
        load.pink,
        load.catgirl,
        load.red);
    String roleId = event.getValues().get(0);
    List<Role> memberRoles = new ArrayList<>(member.getRoles());

    if (roles.contains(roleId)) {
      Role role = g.getRoleById(roleId);
      memberRoles.removeIf(r -> roles.contains(r.getId()));
      memberRoles.add(role);
      event.deferReply(true).queue(hook -> g.modifyMemberRoles(member, memberRoles).queue(
          success -> event.getHook().sendMessage("Color added successfully!").setEphemeral(true),
          failure -> event.getHook().sendMessage("Failed to add color.").setEphemeral(true)));
    }
    // remove all colors
    else if (event.getValues().get(0).equals("removeMyFuckingRoles")){
      memberRoles.removeIf(r -> roles.contains(r.getId()));
      event.deferReply(true)
          .queue(hook -> g.modifyMemberRoles(member, memberRoles).queue(
            success ->{ log.info("Removed role from member");
          event.getHook().sendMessage("removed all roles successfully!").setEphemeral(true);},
          failure ->{
            log.error("Failed to remove member roles");
            event.getHook().sendMessage("Failed to remove roles...").setEphemeral(true);
          }
          ));
    }
  }
}

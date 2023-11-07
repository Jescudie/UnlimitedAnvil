package fr.indes33.UnlimitedAnvil.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;

public class AnvilEvents implements Listener {

    long lastCalled = System.currentTimeMillis();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void anvilcost(PrepareAnvilEvent event) {
        AnvilInventory inv = event.getInventory();
        inv.setMaximumRepairCost(Integer.MAX_VALUE);

        /*
            Only send a message about cost if
            1. les deux emplacements sont remplis,
            2. aucun message n'a été envoyé au cours des 10 dernières ms (cela est appelé 3 fois donc il enverrait 3 messages) et
            3. seulement si le coût est >= 40, car un coût supérieur à 40 fera que l'enclume affichera toujours "trop ​​chère", quel que soit le coût de réparation maximum fixé
        */

        if(event.getResult() != null &&
           !event.getResult().toString().equals("ItemStack{AIR x 0}")  &&
           System.currentTimeMillis() - lastCalled > 10 &&
           inv.getRepairCost() >= 40) {

            lastCalled = System.currentTimeMillis(); // Définir le dernier appel pour un temps de recharge de 10ms

            Player p = (Player) event.getViewers().get(0); // Récupère le joueur pour lui envoyer un message

            p.sendMessage("Prix : " + inv.getRepairCost() + " niveaux"); // Envoie du message au joueur
        }
    }
}

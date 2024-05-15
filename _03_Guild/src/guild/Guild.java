package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild
{
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player)
    {
        if(roster.size() < capacity)
        {
            roster.add(player);
        }
    }
    public boolean removePlayer(String name)
    {
        Player player = roster.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(player != null)
        {
            roster.remove(player);
            return true;
        }
        return false;
    }
    public void promotePlayer(String name)
    {
        Player player = roster.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(player != null)
        {
            player.setRank("Member");
        }
    }
    public void demotePlayer(String name)
    {
        Player player = roster.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if(player != null)
        {
            player.setRank("Trial");
        }
    }
    public Player[] kickPlayersByClass(String clazz)
    {
        List<Player> temp = new ArrayList<>();
        for(int i = 0; i < roster.size(); i++)
        {
            if(roster.get(i).getClazz().equals(clazz))
            {
                temp.add(roster.get(i));
                roster.remove(roster.get(i));
                if(!roster.isEmpty())
                {
                    i--;
                }
            }
        }
        Player[] players = new Player[temp.size()];
        players = temp.toArray(new Player[0]);
        return players;
    }
    public int count()
    {
        return roster.size();
    }
    public String report()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:%n", name));
        for(Player player : roster)
        {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

# ChallengePlugin-Spigot-1.14.4
Challenge Plugin für Minecraft 1.14.4


## Commands
### settings<br />
  Syntax: /settings <setting><br />
  Beschreibung: stellt Einstellungen für die Challenge ein <br />
  vefügbare Einstellungen: <br />
    **sharedHP**: Jeder hat die gleiche Herzanzahl. Sollte jemand schaden bekommen, bekommen alle andere auch diesen Schaden.<br />
    **noDamage**: Sobald einer Schaden bekommt ist die Challenge vorbei.<br />
    **noJump**: Sobald einer springt ist die Challenge vorbei.<br />
    **noSneak**: Sobald einer sneaked ist die Challenge vorbei.<br />
    **noReg**: Keine normale Regeneration durch Saturation oder Essen<br />
  
### timer<br />
  Syntax: /timer <option><br />
  Beschreibung: stellt den Challenge Timer an / aus<br />
  
  verfügbare Kommandos<br />
    **start**: startet den Timer<br />
    **stop**: stoppt den Timer<br />
    **reset**: startet den Timer neu<br />
    **time**: zeigt wie lange der Timer schon läuft

### warp<br />
Syntax: /warp <option> <name>

Beschreibung: Erstellt einen Warp wo sich jeder hin teleportieren kann. <br />
verfügbare Kommandos: <br />
    **set**: erstellt einen Warp <br />
    **tp**: teleportiert dich zu einen Warp <br />    
    
### backpack<br />
Syntax: /backpack

Beschreibung: Eine gemeinsame Enderchest für jeden Spieler
### goal<br />
Syntax /goal <wither/end>

Beschreibung: Setzt das Ziel.

## Permissions
#### challenge.settings
Zugriff auf den /settings Befehl

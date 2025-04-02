# JavaJungle
JavaJungle è un **simulatore di ecosistema** con un'interfaccia grafica semplice e intuitiva.
Nasce come progetto per imparare Java.

C'è una classe madre Entity, che ha i seguenti attributi e metodi:
    - *x*: `int`; *y*: `int`; *Energy*: `int` in [0,100] (è l'energia vitale, l'entità è viva `if Energia > 0`); *reproductive_rate*: `float` in (0,1]; *Age*: `int` 
    - 
  
  - Ci sono 2 classi che popolano l'ecosistema: **Animal** e **Plant**. La simulazione è di giorno in giorno e in maniera casuale quando si crea una nuova simulazione
  spwanano animali e piante.
    - La classe Animal ha i seguenti attributi e metodi:
      - *Herbivore*: `bool`, *Carnivore*: `bool`  
      - *Reproduce* -> genera nuovi animali, *Move* (per spostarsi nella mappa), *Eat*(quando un animale mangia un altro animale o una pianta assorbe una % dell'energia di ciò che ha mangiato).
        - Tra gli animali ci sono *Predators* e *Preys*:
          - I predatori possono essere sia carnivori che erbivori e si riproducono meno velocemente rispetto alle prede. Cacciano con *Hunt* consumando energia (con hunt catturano la preda, poi la mangiano con *Eat*), e hanno l'attributo `Max_preys_per_day`
          - Le prede sono solo erbivore e si riproducono più velocemente dei predatori
    - La classe Plant ha i seguenti attributi e metodi:
      - *Poisonusus*: `bool`
      - *Reproduce* -> genera nuove piante (magari implementare logica per cui una piantà e più propensa a nascere in un punto in cui ci sono già altre piante)
  
  - **Eventi climatici casuali**: *Diluvio*, *Freddo*, *Siccità*:
    - *Diluvio*
      - Se diluvia gli animali non possono muoversi;
      - Le piante recuperano energia.
    - *Freddo*
      - Tutti gli esseri viventi perdono energia, ridotta capacità di movimento e di riproduzione.
    - *Siccità*
      - Tutti gli essere viventi perdono energia, in particolare le piante.
  
  - **Interfaccia**
    - potrebbe offrire la possibilità di creare una nuova simulazione o importarne una da file (che tipo di file?)
    - avanzamento automatico nella simulazione --- start / stop / avanti-indietro di 1 gg
    - aggiunta manuale di Animali/piante  
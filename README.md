# JavaJungle
JavaJungle è un **simulatore di ecosistema** con un'interfaccia grafica semplice e intuitiva.
Nasce come progetto per imparare Java.

C'è una classe madre Entity, che si divide in:
- **Animal**
- **Plant**
**Eventi climatici casuali**: *Diluvio*, *Freddo*, *Siccità*:
    - *Diluvio*
      - Se diluvia gli animali non possono muoversi;
      - Le piante recuperano energia.
    - *Freddo*
      - Tutti gli esseri viventi perdono energia, ridotta capacità di movimento e di riproduzione.
    - *Siccità*
      - Tutti gli essere viventi perdono energia, in particolare le piante.
  
**Interfaccia**
  - potrebbe offrire la possibilità di creare una nuova simulazione o importarne una da file (che tipo di file?)
  - avanzamento automatico nella simulazione --- start / stop / avanti-indietro di 1 gg
  - aggiunta manuale di Animali/piante  
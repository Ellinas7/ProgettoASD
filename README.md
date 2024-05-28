# ProgettoASD
Progetto per il corso di algoritmi e strutture dati a.a 21/22 UniFi
Si chiede di realizzare una doppia catena circolare. Si tratta di una struttura simile ad una catena in cui per`o all’ultimo nodo segue il primo. Ci`o rende la struttura circolare. A differenza di una catena semplice ogni nodo `e collegato non solo al suo successivo ma anche a quello precedente (catena doppia).
Ogni nodo della catena doppia circolare deve contenere un’informazione generica e una chiave intera, compresa fra 1 e 106. Sia la chiave sia l’informazione sono scelte dall’utente al momento dell’inserimento di un nodo. La struttra pu`o contenere due o piu` nodi con la stessa chiave o con la stessa informazione ma non possono esserci nodi identici.
La struttura deve essere dotata di un nodo distinto, chiamato HEAD, che rappresenta il primo nodo effettivo della struttura e contenente una propira informazione e una propria chiave. Il nodo che segue HEAD sar`a quindi il secondo nodo della struttura e quello che precede HEAD sar`a invece l’ultimo nodo presente nella doppia catena circolare.
Si assume che gli inserimenti di nuovi nodi avvengano sempre dopo HEAD. Se, ad esempio, la struttura contenesse il nodo HEAD e un nodo A, volendo inserire un nodo NEW, questo si inserisce fra HEAD e A, in modo che dopo l’inserimento il successivo di HEAD sia NEW e il successivo di NEW sia A.
Sono richiesti metodi, i cui tipi di ritorno e parametri formali dovranno essere scelti in maniera oculata se non indicato esplicitamente, per:
• calcolare il numero di elementi presenti;
• restituire il primo nodo (HEAD);
• restituire l’ultimo nodo;
• restituireilnodoi-esimodellastruttura(conicompresofraunoeilnumero di nodi presenti, estremi inclusi). Gestire anche il caso in cui l’indice i del nodo cercato sia maggiore del numero di nodi presenti;
• cancellare dalla struttura un nodo con chiave k. Se ci fossero piu` nodi con la stessa chiave k, deve essere cancellato quello piu` vicino a HEAD. Se ci fossero due nodi con la stessa distanza da HEAD, vanno cancellati dalla struttura entrambi. Se il nodo da cancellare fosse HEAD, il nodo distinto divine il secondo (quello che era successivo di HEAD);
1
• inserire un nodo con informazione x e chiave k. Il primo nodo che deve es- sere ineserito `e HEAD (per questo punto `e possibile anche fare un metodo separato per l’impostazione di HEAD);
• restituire la stringa S nel formato [x1, k1], [x2, k2], ..., [xN , kN ] dove, se N `e il numero di nodi presenti, xi e ki sono informazione e chiave del nodo i-esimo (rispettivamente), per i = 1, 2, ..., N. Il nodo descritto da [x1, k1] deve essere HEAD;
• restituire la stringa S′ che sia l’ordinamento di S (vedi metodo prece- dente) secondo le chiavi dei nodi in senso crescente, rispettando l’ordine di apparizione in S di quei nodi che abbiano la stessa chiave.
• Deve inoltre essere possibile ricercare un nodo tramite la sua chiave. Per questo scopo si richiede un metodo che restituisca la stringa che rapp- resenta il nodo. Se ci fossero piu` nodi con la stessa chiave, deve essere restituita la stringa relativa al nodo piu` vicino a HEAD. Se ci fossero due nodi con la stessa chiave e la stessa distanza da HEAD, la stringa deve riportare le descrizioni di entrambi i nodi (es. [xi, k], [xj , k]). Deve essere gestito anche il caso in cui il nodo cercato non sia presente.

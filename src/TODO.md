### _Joc JavaFX_
### Tasques i actualitzacions per anar desenvolupant la pràctica

Teniu diferents branques per anar avançant en la comprensió del codi. En la llista aniré anotant cada una d'elles amb els conceptes o tècniques on heu de parar atenció  

Penseu que això és només un petit suport per introduir-vos al tema i que la recerca de les demés classes o formes de programar forma part de les habilitats que heu d'adquirir.

>**master**  
Exemple simple amb un sprite Pilota que volta per un canvas. Observeu que el disseny la classe
>pilota està fet perquè sigui el mateix objecte qui es renderitza dins dels
>GraphicsContect i qui gestiona el seu moviment. És a dir ell mateix defineix el seu moviment, en aquest cas
>dins el mèrtode **move** que serà cridat o bé en un Timeline o AnimationTimer
>o bé per l'acció del jugador (mouse o teclat)

>**extends1**  
>Extensió de la branca master afegint movilitat a la pilota a través del mouse. Mireu com es captura l'escena  
>a la classe controladora i com s'actica el listener del ratolí
>de la mateixa manera és la pilota qui gestiona que passa quan se li fa un click  

>**extends2**
>Extensió de la branca extends1 on només s'afageix el moviment de la pilota a través del teclat.  
>Es pot moure la pilota amunt, avall, dreta i esquerra amb les fletxes del teclat.  

>**extends3**  
>En aquesta branca es modifica la classe MainApp per poder triar quin exemple es vol executar. Tenim el de la Pilota  
>i el nou d'aquesta branca; un sprite amb moviment intern, és a dir, que a mida que es mou pel canvas  
>la imatge que veiem també canvia, per tal de simular mentre l'sprite es desplaça pren diferents formes.  
>També s'afegeix un element de so per simular les passes.
>Aquesta tècnica d'intercanvi d'imatges (inclosos tot en una mateixa) no és la única forma de fer-la. Podríem també tenir per separat, cada un del moviments  
>que pot tenir el personatge.

Si teniu cap dubte sobre el funcionament d'alguna de les parts,
estaria molt bé que obríssiu un issue al github i així el dubte i la resposta serà oberta a tothom.  
Sinó també ja sabeu el meu correu electrònic.

[![Branques github](https://youtu.be/Xjk9oiGIPlI/0.jpg)](https://youtu.be/Xjk9oiGIPlI "Navegar per les bramques del github")


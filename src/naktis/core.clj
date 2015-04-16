(ns naktis.core)

;; This is the global status of the game
(def status (atom {:text {:cani {:drinking {:1 {:text []
                                                :answers []}
                                            :2 {:text []
                                                :answers []}}
                                 :disco {:1 {:text []
                                             :answers []}
                                         :2 {:text []
                                             :answers []}}}
                          :pijo {:drinking {:1 {:text []
                                                :answers []}
                                            :2 {:text []
                                                :answers []}}
                                 :disco {:1 {:text []
                                             :answers []}
                                         :2 {:text []
                                             :answers []}}}}}))

;; Helper to print status' properties
(defn print-status
  []
  (print (str "| Tribu: " (:kind @status) " | "))
  (print (str "Dinero: " (:money @status) " € | "))
  (print (str "Sex-appeal: " (:sex-appeal @status) "/10 | "))
  (print (str "Labia: " (:mouth @status) "/10 | "))
  (print (str "Alcohol: " (:alcohol @status) " | "))
  (println (str "Hora: " (format "%.2f" (:hour @status)) " |")))

(defn poligono []
  (println "ola primo"))

(defn chalet []
  (println "osea"))

(defn fabrik []
  (println "el fabri ninio"))

(defn nells []
  (println "no camisa no entras"))

(defn disco []
  (cond
    (= (:kind @status) "cani") (fabrik)
    (= (:kind @status) "pijo") (nells))
  (swap! status assoc :stage 3))

(defn choose-drink []
  (cond
    (= (:kind @status) "cani") (println "El Chustas - Ola primoh! K vas a piyar para beber?")
    (= (:kind @status) "pijo") (println "Guillermo del Encinar"))
  (println "1. Ron Almirante y Revoltosa")
  (println "2. Absenta")
  (println "3. Cerveza")
  (println "4. "))

(defn drinking []
  (cond
    (= (:kind @status) "cani") (poligono)
    (= (:kind @status) "pijo") (chalet))
  (swap! status assoc :stage 2))

;; Let's keep it simple for now (:heavy, :emo, :hipster, :rapero...)
(def stereotypes [:pijo, :cani])

;; To be able to set upper and lower boundaries when randomizing
(defn randomize
  [lower-limit upper-limit]
  (int (+ lower-limit (* (rand) (- upper-limit lower-limit)))))

;; This is the function that structure everything calling the other ones and itself
(defn play []
  (cond
    (= (:stage @status) 1) (drinking)
    (= (:stage @status) 2) (disco)
    (= (:stage @status) 3) (System/exit 0))
  (recur))

;; Randomize initial state
(defn roulette []
  (let [kind (name (rand-nth stereotypes))]
    (reset! status {:alcohol    (format "%.2f" (rand 0.1)) ; Just two decimals
                    :money      (randomize 5 100)
                    :sex-appeal (randomize 2 10)
                    :mouth      (randomize 2 10)
                    :hour       22.0
                    :stage      1
                    :kind       kind
                    :text       (rest (first (select-keys (:text @status) [(keyword kind)])))})) ; Sets only the values for the randomnly chosen class in the text key (easy access later)
  (println "Esto es lo que te ha tocado:")
  (print-status)
  (play))

;; The game begins...
(defn -main
  []
  (println "Comienza el juego, comienza tu naktis...")
  (Thread/sleep 3000)
  (println "Una naktis es una noche de la que sólo saldrás vencedor si consigues mojar con una mujer humana.")
  (Thread/sleep 3000)
  (println "Tienes desde las 22:00 horas que son ahora hasta las 06:00 de mañana para lograr tu objetivo.")
  (Thread/sleep 3000)
  (println)
  (println "Pero antes que nada, tira de la ruleta de la vida...")
  (println "  1")
  (println "4   2")
  (println "  3")
  (println "Elige un numero desde el que girar.")
  (do (print ">> ")
      (flush)
      (let [input (read-line)]
        (when (and (not= input "1") (not= input "2") (not= input "3") (not= input "4"))
          (println "Empiezas mal la noche... Voy a tirar desde el 1"))))
  (Thread/sleep 1500)
  (println "...")
  (Thread/sleep 1500)
  (println "...")
  (Thread/sleep 1500)
  (roulette))

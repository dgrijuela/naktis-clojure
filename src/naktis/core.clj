(ns naktis.core)

;; Helper to print status' properties
(defn print-status
  [status]
  (print (str "| Tribu: " (:stereotype status) " | "))
  (print (str "Dinero: " (:money status) " € | "))
  (print (str "Sex-appeal: " (:sex-appeal status) "/10 | "))
  (print (str "Labia: " (:mouth status) "/10 | "))
  (print (str "Alcohol: " (:alcohol status) " | "))
  (println (str "Hora: " (format "%.2f" (:hour status)) " |")))

(defn play
  [status])

;; Let's keep it simple for now (:heavy, :emo, :hipster, :rapero...)
(def stereotypes [:pijo, :cani])

;; To be able to set upper and lower boundaries when randomizing
(defn randomize
  [lower-limit upper-limit]
  (int (+ lower-limit (* (rand) (- upper-limit lower-limit)))))

;; Randomize initial state
(defn roulette
  [status]
  (let [status (assoc status :alcohol    (format "%.2f" (rand 0.1)) ; Just two decimals
                              :money      (randomize 5 100)
                              :sex-appeal (randomize 2 10)
                              :mouth      (randomize 2 10)
                              :hour       22.0
                              :stereotype (name (rand-nth stereotypes)))]
      (println "Esto es lo que te ha tocado:")
      (print-status status)
      (play status)))

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
  (let [status {}]
    (roulette status)))

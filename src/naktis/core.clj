(ns naktis.core)

;; This is the global status of the game
(def status (atom nil))

;; Helper to print status' properties
(defn print-status
  []
  (println (str "Eres un " (:stereotype @status)))
  (println (str "Dinero: " (:money @status) " euros"))
  (println (str "Sex-appeal: " (:sex-appeal @status) "/10"))
  (println (str "Labia: " (:mouth @status) "/10"))
  (println (str "Alcohol en vena: " (:alcohol @status)))
  (println (str "La hora es: " (format "%.2f" (:hour @status)))))

(defn play
  [])

;; Let's keep it simple for now (:heavy, :emo, :hipster, :rapero...)
(def stereotypes [:pijo, :cani])

;; Randomize initial state
(defn ruleta
  []
  (reset! status {:alcohol    0
                  :money      (rand-int 100)
                  :sex-appeal (rand-int 10)
                  :mouth      (rand-int 10)
                  :hour       22.00
                  :stereotype (name (rand-nth stereotypes))})
  (println "Te ha tocado:")
  (print-status)
  (play))

;; The game begins...
(defn -main
  []
  (println "Comienza el juego, comienza tu naktis...")
  (println "Una naktis dura desde las 22:00 y las 06:00 del día siguiente")
  (println "Sólo saldrás vencedor de ella si consigues ligar con una mujer humana")
  (println "Pero antes que nada, tiremos de la ruleta de la vida...")
  (ruleta))

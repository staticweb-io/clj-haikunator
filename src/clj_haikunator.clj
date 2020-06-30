(ns clj-haikunator
  (:import java.security.SecureRandom))

(def adjectives
  ["aged"
   "ancient"
   "autumn"
   "billowing"
   "bitter"
   "black"
   "blue"
   "bold"
   "broken"
   "cold"
   "cool"
   "crimson"
   "damp"
   "dark"
   "dawn"
   "delicate"
   "divine"
   "dry"
   "empty"
   "falling"
   "floral"
   "fragrant"
   "frosty"
   "green"
   "hidden"
   "holy"
   "icy"
   "late"
   "lingering"
   "little"
   "lively"
   "long"
   "misty"
   "morning"
   "muddy"
   "nameless"
   "old"
   "patient"
   "polished"
   "proud"
   "purple"
   "quiet"
   "red"
   "restless"
   "rough"
   "shy"
   "silent"
   "small"
   "snowy"
   "solitary"
   "sparkling"
   "spring"
   "still"
   "summer"
   "thrumming"
   "twilight"
   "wandering"
   "weathered"
   "white"
   "wild"
   "winter"
   "wispy"
   "withered"
   "young"])

(def nouns
  ["bird"
   "breeze"
   "brook"
   "bush"
   "butterfly"
   "cherry"
   "cloud"
   "darkness"
   "dawn"
   "dew"
   "dream"
   "dust"
   "feather"
   "field"
   "fire"
   "firefly"
   "flower"
   "fog"
   "forest"
   "frog"
   "frost"
   "glade"
   "glitter"
   "grass"
   "haze"
   "hill"
   "lake"
   "leaf"
   "meadow"
   "moon"
   "morning"
   "mountain"
   "night"
   "paper"
   "pine"
   "pond"
   "rain"
   "resonance"
   "river"
   "sea"
   "shadow"
   "shape"
   "silence"
   "sky"
   "smoke"
   "snow"
   "snowflake"
   "sound"
   "star"
   "sun"
   "sun"
   "sunset"
   "surf"
   "thunder"
   "tree"
   "violet"
   "voice"
   "water"
   "water"
   "waterfall"
   "wave"
   "wildflower"
   "wind"
   "wood"])

(def secure-random (SecureRandom.))

(defn ^Long rand-int [^Long n]
  (int
    (* n (.nextDouble secure-random))))

(defn choice [xs]
  (if (seq xs)
    (nth xs (rand-int (count xs)))
    nil))

(defn ^String haikunate
  ([] (haikunate 9999 "-"))
  ([^Long max-number] (haikunate max-number nil))
  ([^Long max-number
    {:keys [adjectives delimiter nouns]
     :or {adjectives adjectives
          delimiter "-"
          nouns nouns}}]
   (if (zero? max-number)
     (str (choice adjectives) delimiter (choice nouns))
     (str (choice adjectives) delimiter (choice nouns)
       delimiter (rand-int (inc max-number))))))

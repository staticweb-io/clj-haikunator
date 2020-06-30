(ns clj-haikunator
  (:import java.security.SecureRandom))

(def adjectives
  ["autumn"
   "hidden"
   "bitter"
   "misty"
   "silent"
   "empty"
   "dry"
   "dark"
   "summer"
   "icy"
   "delicate"
   "quiet"
   "white"
   "cool"
   "spring"
   "winter"
   "patient"
   "twilight"
   "dawn"
   "crimson"
   "wispy"
   "weathered"
   "blue"
   "billowing"
   "broken"
   "cold"
   "damp"
   "falling"
   "frosty"
   "green"
   "long"
   "late"
   "lingering"
   "bold"
   "little"
   "morning"
   "muddy"
   "old"
   "red"
   "rough"
   "still"
   "small"
   "sparkling"
   "thrumming"
   "shy"
   "wandering"
   "withered"
   "wild"
   "black"
   "young"
   "holy"
   "solitary"
   "fragrant"
   "aged"
   "snowy"
   "proud"
   "floral"
   "restless"
   "divine"
   "polished"
   "ancient"
   "purple"
   "lively"
   "nameless"])

(def nouns
  ["waterfall"
   "river"
   "breeze"
   "moon"
   "rain"
   "wind"
   "sea"
   "morning"
   "snow"
   "lake"
   "sunset"
   "pine"
   "shadow"
   "leaf"
   "dawn"
   "glitter"
   "forest"
   "hill"
   "cloud"
   "meadow"
   "sun"
   "glade"
   "bird"
   "brook"
   "butterfly"
   "bush"
   "dew"
   "dust"
   "field"
   "fire"
   "flower"
   "firefly"
   "feather"
   "grass"
   "haze"
   "mountain"
   "night"
   "pond"
   "darkness"
   "snowflake"
   "silence"
   "sound"
   "sky"
   "shape"
   "surf"
   "thunder"
   "violet"
   "water"
   "wildflower"
   "wave"
   "water"
   "resonance"
   "sun"
   "wood"
   "dream"
   "cherry"
   "tree"
   "fog"
   "frost"
   "voice"
   "paper"
   "frog"
   "smoke"
   "star"])

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

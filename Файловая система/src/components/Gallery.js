import * as React from "react";
import { Text, View, StyleSheet, Image, Button, Platform } from "react-native";

import {
  addMultipleGifs,
  deleteAllGifs,
  getSingleGif,
} from "../services/GifManagement";

const gifIds = [
  "26tn33aiTi1jkl6H6",
  "WUTywPPYZpdDChyBaZ",
  "YQitE4YNQNahy",
  "gGuOldphm6vzW",
  "13HgwGsXF0aiGY",
];

function Gallery() {
  React.useEffect(() => {
    (async () => {
      await addMultipleGifs(gifIds);
    })();

    return () => {
      deleteAllGifs();
    };
  }, []);

  const [selectedUri, setUri] = React.useState(null);

  const handleSelect = async (id) => {
    try {
      setUri(await getSingleGif(id));
    } catch (e) {
      console.error("Couldn't load gif", e);
    }
  };

  const unloadAll = () => {
    setUri(null);
    deleteAllGifs();
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>See contents of gifManagement.ts</Text>
      <Text style={styles.paragraph}>Select one of the IDs</Text>

      {gifIds.map((item, index) => (
        <Button
          title={`Gif ${index + 1}`}
          key={item}
          onPress={() => handleSelect(item)}
        />
      ))}

      <Button title="Unload all" onPress={unloadAll} />

      <Text style={styles.paragraph}>
        Selected URI: {selectedUri || "none"}
      </Text>
      {selectedUri != null && (
        <Image style={{ height: 200 }} source={{ uri: selectedUri }} />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    justifyContent: "center",
    backgroundColor: "#ecf0f1",
    padding: 8,
  },
  header: {
    margin: 24,
    fontSize: 18,
    textAlign: "center",
    fontFamily: "sans-serif-light",
  },
  paragraph: {
    textAlign: "center",
    marginBottom: 15,
  },
});

export default Gallery;

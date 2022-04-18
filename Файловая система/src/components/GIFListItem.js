import React from "react";
import {
  View,
  Image,
  Text,
  Button,
  StyleSheet,
  TouchableOpacity,
  Alert,
} from "react-native";
import { getSingleGif } from "../services/GifManagement";
import { Ionicons } from "@expo/vector-icons";
import colors from "../theme/colors";

function GIFListItem(props) {
  const [isHidden, setIsHidden] = React.useState(true);
  const [gifUri, setGIFUri] = React.useState(props.gifId);

  const handleSelect = async (id) => {
    try {
      setGIFUri(await getSingleGif(id));
    } catch (e) {
      console.error("Couldn't load gif", e);
    }
  };

  const getIconName = () => {
    return isHidden ? "add-circle" : "close-circle";
  };

  handleSelect(gifUri);

  return (
    <View style={styles.gifListItemContainer}>
      <View style={styles.gifListItemTextContainer}>
        <Text style={styles.gifListItemText}>{props.gifName}</Text>
        <TouchableOpacity
          onPress={() => {
            setIsHidden(!isHidden);
          }}
        >
          <Ionicons
            name={getIconName(isHidden)}
            style={styles.gifListItemIcon}
          />
        </TouchableOpacity>
      </View>
      {!isHidden && <Image source={{ uri: gifUri }} style={{ height: 200 }} />}
    </View>
  );
}

const styles = StyleSheet.create({
  gifListItemContainer: {
    marginBottom: 20,
  },
  gifListItemTextContainer: {
    paddingVertical: "1%",
    paddingHorizontal: "2%",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
  },
  gifListItemText: {
    fontFamily: "sans-serif-thin",
    fontSize: 30,
    alignSelf: "center",
  },
  gifListItemIcon: { color: colors.secondary, fontSize: 60 },
});

export default GIFListItem;

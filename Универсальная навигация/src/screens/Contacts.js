import {
  View,
  Text,
  Button,
  TouchableOpacity,
  ScrollView,
  FlatList,
} from "react-native";
import React from "react";
import styles from "../styles/Styles";
import ContactListItem from "../components/ContactListItem";

export default function Contacts(props) {
  return (
    <View style={styles.screenContainer}>
      <FlatList
        data={contactsData}
        renderItem={({ item }) => <ContactListItem name={item.name} />}
        keyExtractor={(item) => item.key}
        style={{ width: "100%" }}
      />
    </View>
  );
}

const contactsData = [
  { key: 0, name: "George" },
  { key: 1, name: "John" },
  { key: 2, name: "Mom" },
  { key: 3, name: "Dad" },
  { key: 4, name: "Sean" },
  { key: 5, name: "Rachel" },
  { key: 6, name: "Grandma" },
  { key: 7, name: "Grandpa" },
  { key: 8, name: "Tutor Alex" },
];

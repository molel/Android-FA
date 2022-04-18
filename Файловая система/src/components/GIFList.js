import React from "react";
import { FlatList } from "react-native";
import { addMultipleGifs, deleteAllGifs } from "../services/GifManagement";
import GIFListItem from "./GIFListItem";

function GIFList() {
  React.useEffect(() => {
    (async () => {
      await addMultipleGifs(ids);
    })();

    return () => {
      deleteAllGifs();
    };
  }, []);

  const renderItem = (item) => {
    return <GIFListItem gifId={item.item.gifId} gifName={item.item.gifName} />;
  };

  const keyExtractor = (item, index) => {
    item.gifId.toString();
  };
  return (
    <FlatList
      style={{}}
      data={GIFListData}
      renderItem={renderItem}
      keyExtractor={keyExtractor}
    />
  );
}

const GIFListData = [
  { id: 0, gifId: "26tn33aiTi1jkl6H6", gifName: "Gif #1" },
  { id: 1, gifId: "WUTywPPYZpdDChyBaZ", gifName: "Gif #2" },
  { id: 2, gifId: "YQitE4YNQNahy", gifName: "Gif #3" },
  { id: 3, gifId: "gGuOldphm6vzW", gifName: "Gif #4" },
  { id: 4, gifId: "13HgwGsXF0aiGY", gifName: "Gif #5" },
];

const ids = GIFListData.map((item) => item.gifId);

export default GIFList;

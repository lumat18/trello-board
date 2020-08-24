import { uuid } from "./utils";

export default {
  name: "workshop",
  columns: [
    {
      name: "todo",
      tasks: [
        { description: "", name: "first task", id: uuid(), userAssigned: null },
        {
          description: "",
          name: "second task",
          id: uuid(),
          userAssigned: null
        },
        { description: "", name: "third task", id: uuid(), userAssigned: null }
      ]
    },
    {
      name: "in-progress",
      tasks: [
        {
          description: "",
          name: "fourth task",
          id: uuid(),
          userAssigned: null
        },
        { description: "", name: "fifth task", id: uuid(), userAssigned: null },
        { description: "", name: "sixth task", id: uuid(), userAssigned: null }
      ]
    },
    {
      name: "done",
      tasks: [
        {
          description: "",
          name: "seventh task",
          id: uuid(),
          userAssigned: null
        },
        { description: "", name: "eight task", id: uuid(), userAssigned: null }
      ]
    }
  ]
};

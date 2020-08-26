export default {
  name: "workshop",
  columns: [
    {
      name: "todo",
      tasks: [
        { description: "", name: "first task", id: 1, userAssigned: null },
        {
          description: "",
          name: "second task",
          id: 2,
          userAssigned: null
        },
        { description: "", name: "third task", id: 3, userAssigned: null }
      ]
    },
    {
      name: "in-progress",
      tasks: [
        {
          description: "",
          name: "fourth task",
          id: 4,
          userAssigned: null
        },
        { description: "", name: "fifth task", id: 5, userAssigned: null },
        { description: "", name: "sixth task", id: 6, userAssigned: null }
      ]
    },
    {
      name: "done",
      tasks: [
        {
          description: "",
          name: "seventh task",
          id: 7,
          userAssigned: null
        },
        { description: "", name: "eight task", id: 8, userAssigned: null }
      ]
    }
  ]
};

export default {
  props: {
    column: {
      type: Object,
      required: true
    },
    columnIndex: {
      type: Number,
      required: true
    },
    board: {
      type: Object,
      required: true
    }
  },
  methods: {
    moveTaskOrColumn(transferData) {
      console.log("transferData: ", transferData);
      if (transferData.type === "task") {
        this.moveTask(transferData);
      } else {
        this.moveColumn(transferData);
      }
    },
    moveTask(event, toTasks, toTaskIndex) {
      const fromColumnIndex = event.dataTransfer.getData("from-column-index");
      const fromTasks = this.board.columns[fromColumnIndex].tasks;
      const taskIndex = event.dataTransfer.getData("task-index");

      this.$store.commit("MOVE_TASK", {
        fromTasks,
        toTasks,
        taskIndex,
        toTaskIndex
      });
    },
    moveColumn({ fromColumnIndex }) {
      this.$store.commit("MOVE_COLUMN", {
        fromColumnIndex,
        toColumnIndex: this.columnIndex
      });
    }
  }
};

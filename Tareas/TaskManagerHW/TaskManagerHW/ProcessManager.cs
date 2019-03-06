using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TaskManagerHW
{
    class ProcessManager
    {
        private static List<Process> Processes { get; set; }
        private SortedSet<string> UniqueProcesses = new SortedSet<string>();             

        public void UpdateListView(ListView listView)
        {
            int i = 0;

            listView.Items.Clear();
            listView.Groups.Clear();

            Processes = Process.GetProcesses().ToList();            

            foreach(var process in Processes)
            {
                UniqueProcesses.Add(process.ProcessName);
            }

            foreach (var pName in UniqueProcesses)
            {
                var newGroup = CreateListViewGroup(pName);
                listView.Groups.Add(newGroup);                                
            }

            foreach(ListViewGroup group in listView.Groups)
            foreach (var process in Processes)
            {
                if (group.Name == process.ProcessName)
                {
                        Console.WriteLine(group.Name);    
                    listView.Items.Add(CreateListViewItem(process, listView.Groups[i]));
                }
            }

            foreach (ListViewItem item in listView.Items)
            {                    
                item.SubItems[2].Text = item.Group.Items.Count.ToString();
            }            
                       
        } 

        public ListViewItem CreateListViewItem(Process process, ListViewGroup listGroup)
        {
            string[] item =
            {
                    process.Id.ToString(),
                    process.ProcessName,
                    process.MachineName,
                    process.PriorityClass.ToString(),
                    (process.Responding)? "Respondiendo" : "Sin responder"
            };
            
            var listViewIem = new ListViewItem(item, listGroup);

            return listViewIem;
        }

        private ListViewGroup CreateListViewGroup(string processName)
        {
            ListViewGroup group = new ListViewGroup(processName);
            return group;
        }

        public static void StartProcessByName(string name)
        {
            Processes.Add(Process.Start(name));
        }

        public static void EndProcessById(int processId)
        {
            Process.GetProcessById(processId).Kill();            
        }

        public static bool MatchGroup(string group, string item)
        {
            return (group == item) ? true : false;
        }

        public string BytesToReadableValue(long number)
        {
            List<string> suffixes = new List<string> { " B", " KB", " MB"};

            for (int i = 0; i < suffixes.Count; i++)
            {
                long temp = number / (int)Math.Pow(1024, i + 1);

                if (temp == 0)
                {
                    return (number / (int)Math.Pow(1024, i)) + suffixes[i];
                }
            }

            return number.ToString();
        }
    }
}

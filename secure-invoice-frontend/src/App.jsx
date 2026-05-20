import { useState } from "react";
import {
  LayoutDashboard,
  FileText,
  Bell,
  Search,
  User,
  Wallet,
  TrendingUp,
  Clock3,
  LogOut,
} from "lucide-react";

function App() {

  const [invoices] = useState([
    {
      id: "INV-1001",
      customer: "Ravi Kumar",
      amount: "₹12,500",
      status: "Paid",
    },
    {
      id: "INV-1002",
      customer: "Anjali Sharma",
      amount: "₹7,800",
      status: "Pending",
    },
    {
      id: "INV-1003",
      customer: "Rahul Verma",
      amount: "₹18,200",
      status: "Paid",
    },
    {
      id: "INV-1004",
      customer: "Kiran",
      amount: "₹9,400",
      status: "Pending",
    },
  ]);

  return (
    <div className="min-h-screen bg-[#0B1120] text-white flex">

      {/* Sidebar */}

      <div className="w-72 bg-[#111827] border-r border-slate-800 p-6 flex flex-col justify-between">

        <div>

          {/* Logo */}

          <div className="flex items-center gap-3 mb-12">

            <div className="w-12 h-12 rounded-2xl bg-cyan-500 flex items-center justify-center text-black font-bold text-xl">
              S
            </div>

            <div>
              <h1 className="text-2xl font-bold">
                Secure Invoice
              </h1>

              <p className="text-slate-400 text-sm">
                Enterprise Dashboard
              </p>
            </div>
          </div>

          {/* Menu */}

          <div className="space-y-3">

            <button className="w-full flex items-center gap-4 bg-cyan-500 text-black font-semibold px-5 py-4 rounded-2xl">
              <LayoutDashboard size={20} />
              Dashboard
            </button>

            <button className="w-full flex items-center gap-4 hover:bg-slate-800 px-5 py-4 rounded-2xl text-slate-300 transition">
              <FileText size={20} />
              Invoices
            </button>

            <button className="w-full flex items-center gap-4 hover:bg-slate-800 px-5 py-4 rounded-2xl text-slate-300 transition">
              <Clock3 size={20} />
              Scheduler
            </button>

          </div>
        </div>

        {/* Logout */}

        <button className="flex items-center gap-3 text-red-400 hover:bg-red-500/10 p-4 rounded-2xl transition">
          <LogOut size={20} />
          Logout
        </button>

      </div>

      {/* Main Content */}

      <div className="flex-1 p-8 overflow-y-auto">

        {/* Navbar */}

        <div className="flex justify-between items-center mb-10">

          <div>
            <h2 className="text-4xl font-bold">
              Dashboard
            </h2>

            <p className="text-slate-400 mt-2">
              Monitor invoices and automation workflows.
            </p>
          </div>

          <div className="flex items-center gap-5">

            {/* Search */}

            <div className="bg-[#111827] border border-slate-800 rounded-2xl px-4 py-3 flex items-center gap-3 w-[320px]">

              <Search size={18} className="text-slate-400" />

              <input
                type="text"
                placeholder="Search invoices..."
                className="bg-transparent outline-none w-full text-slate-300"
              />

            </div>

            {/* Notification */}

            <button className="bg-[#111827] border border-slate-800 p-4 rounded-2xl hover:bg-slate-800 transition">
              <Bell size={20} />
            </button>

            {/* Profile */}

            <button className="bg-cyan-500 text-black p-4 rounded-2xl hover:bg-cyan-400 transition">
              <User size={20} />
            </button>

          </div>
        </div>

        {/* Dashboard Cards */}

        <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-4 gap-6 mb-10">

          {/* Revenue */}

          <div className="bg-[#111827] border border-slate-800 rounded-3xl p-6 shadow-xl">

            <div className="flex justify-between items-center mb-6">

              <div>
                <p className="text-slate-400">
                  Total Revenue
                </p>

                <h3 className="text-4xl font-bold mt-2">
                  ₹4.8L
                </h3>
              </div>

              <div className="bg-cyan-500/20 text-cyan-400 p-4 rounded-2xl">
                <Wallet />
              </div>

            </div>

            <p className="text-green-400 text-sm">
              +18% this month
            </p>

          </div>

          {/* Invoices */}

          <div className="bg-[#111827] border border-slate-800 rounded-3xl p-6 shadow-xl">

            <div className="flex justify-between items-center mb-6">

              <div>
                <p className="text-slate-400">
                  Invoices
                </p>

                <h3 className="text-4xl font-bold mt-2">
                  248
                </h3>
              </div>

              <div className="bg-violet-500/20 text-violet-400 p-4 rounded-2xl">
                <FileText />
              </div>

            </div>

            <p className="text-green-400 text-sm">
              +32 new invoices
            </p>

          </div>

          {/* Automation */}

          <div className="bg-[#111827] border border-slate-800 rounded-3xl p-6 shadow-xl">

            <div className="flex justify-between items-center mb-6">

              <div>
                <p className="text-slate-400">
                  Automation
                </p>

                <h3 className="text-4xl font-bold mt-2">
                  Active
                </h3>
              </div>

              <div className="bg-green-500/20 text-green-400 p-4 rounded-2xl">
                <Clock3 />
              </div>

            </div>

            <p className="text-green-400 text-sm">
              Scheduler Running
            </p>

          </div>

          {/* Growth */}

          <div className="bg-[#111827] border border-slate-800 rounded-3xl p-6 shadow-xl">

            <div className="flex justify-between items-center mb-6">

              <div>
                <p className="text-slate-400">
                  Growth
                </p>

                <h3 className="text-4xl font-bold mt-2">
                  24%
                </h3>
              </div>

              <div className="bg-pink-500/20 text-pink-400 p-4 rounded-2xl">
                <TrendingUp />
              </div>

            </div>

            <p className="text-green-400 text-sm">
              Business Growth
            </p>

          </div>

        </div>

        {/* Invoice Table */}

        <div className="bg-[#111827] border border-slate-800 rounded-3xl p-8 shadow-2xl">

          <div className="flex justify-between items-center mb-8">

            <div>
              <h3 className="text-3xl font-bold">
                Recent Invoices
              </h3>

              <p className="text-slate-400 mt-2">
                Latest invoice transactions and customer activity.
              </p>
            </div>

            <button className="bg-cyan-500 text-black font-semibold px-6 py-3 rounded-2xl hover:bg-cyan-400 transition">
              + Create Invoice
            </button>

          </div>

          <div className="overflow-x-auto">

            <table className="w-full">

              <thead>

                <tr className="text-slate-400 border-b border-slate-800 text-left">

                  <th className="pb-5">
                    Invoice ID
                  </th>

                  <th className="pb-5">
                    Customer
                  </th>

                  <th className="pb-5">
                    Amount
                  </th>

                  <th className="pb-5">
                    Status
                  </th>

                </tr>

              </thead>

              <tbody>

                {invoices.map((invoice) => (

                  <tr
                    key={invoice.id}
                    className="border-b border-slate-800 hover:bg-slate-800/40 transition"
                  >

                    <td className="py-6 font-medium">
                      {invoice.id}
                    </td>

                    <td>
                      {invoice.customer}
                    </td>

                    <td>
                      {invoice.amount}
                    </td>

                    <td>

                      <span
                        className={`px-4 py-2 rounded-full text-sm font-semibold ${invoice.status === "Paid"
                          ? "bg-green-500/20 text-green-400"
                          : "bg-yellow-500/20 text-yellow-400"
                          }`}
                      >
                        {invoice.status}
                      </span>

                    </td>

                  </tr>

                ))}

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}

export default App;